package com.leyou.cart.service.impl;

import com.leyou.cart.client.GoodsClient;
import com.leyou.cart.interceptor.LoginInterceptor;
import com.leyou.cart.pojo.Cart;
import com.leyou.cart.service.ICartService;
import com.leyou.common.pojo.UserInfo;
import com.leyou.common.utils.JsonUtils;
import com.leyou.item.pojo.Sku;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lgl
 * @Description:
 * @date 2020/3/10 4:01 下午
 */
@Service
public class CartServiceImpl implements ICartService {
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private GoodsClient goodsClient;

    private static final String KEY_PREFIX = "user:cart:";

    @Override
    public void addCart(Cart cart) {
        // 获取用户信息
        UserInfo userInfo = LoginInterceptor.getUserInfo();
        // 查询购物车记录
        BoundHashOperations<String, Object, Object> hashOperations = redisTemplate.boundHashOps(KEY_PREFIX + userInfo.getId());
        String key = cart.getSkuId().toString();
        Integer num = cart.getNum();
        // 判断当前的商品是否在购物车中
        if (hashOperations.hasKey(key)) {
            // 在,更新
            String cartJson = hashOperations.get(key).toString();
            cart = JsonUtils.parse(cartJson, Cart.class);
            cart.setNum(cart.getNum() + num);
        } else {
            // 不在,新增购物车
            cart.setUserId(userInfo.getId());
            Sku sku = goodsClient.querySkuById(cart.getSkuId());
            cart.setImage(StringUtils.isBlank(sku.getImages()) ? "" : sku.getImages());
            cart.setOwnSpec(sku.getOwnSpec());
            cart.setPrice(sku.getPrice());
            cart.setTitle(sku.getTitle());
        }
        hashOperations.put(key, JsonUtils.serialize(cart));

    }

    @Override
    public List<Cart> queryCats() {
        // 获取用户信息
        UserInfo userInfo = LoginInterceptor.getUserInfo();
        // 判断用户是否有购物车记录
        if (!redisTemplate.hasKey(KEY_PREFIX + userInfo.getId())) {
            return null;
        }
        // 查询购物车记录
        BoundHashOperations<String, Object, Object> hashOperations = redisTemplate.boundHashOps(KEY_PREFIX + userInfo.getId());
        // 获取购物车Map中所有Cart值集合
        List<Object> cartsJson = hashOperations.values();
        // 如果购物车集合为空
        if (CollectionUtils.isEmpty(cartsJson)) {
            return null;
        }
        // 把List<Object>集合转化为List<Cart>
        return cartsJson.stream().map(cartJson -> JsonUtils.parse(cartJson.toString(), Cart.class)).collect(Collectors.toList());
    }

    @Override
    public void updateCart(Cart cart) {
        // 获取用户信息
        UserInfo userInfo = LoginInterceptor.getUserInfo();
        // 判断用户是否有购物车记录
        if (!redisTemplate.hasKey(KEY_PREFIX + userInfo.getId())) {
            return;
        }
        // 查询购物车记录
        BoundHashOperations<String, Object, Object> hashOperations = redisTemplate.boundHashOps(KEY_PREFIX + userInfo.getId());
        String key = cart.getSkuId().toString();
        Integer num = cart.getNum();
        // 判断购物车中是否有该商品
        if (hashOperations.hasKey(key)) {
            // 在,更新
            String cartJson = hashOperations.get(key).toString();
            cart = JsonUtils.parse(cartJson, Cart.class);
            cart.setNum(cart.getNum() + num);
            hashOperations.put(key, JsonUtils.serialize(cart));
        }
    }

    @Override
    public List<Cart> deleteCart(Cart cart) {
        // 获取用户信息
        UserInfo userInfo = LoginInterceptor.getUserInfo();
        // 判断用户是否有购物车记录
        if (!redisTemplate.hasKey(KEY_PREFIX + userInfo.getId())) {
            return null;
        }
        // 查询购物车记录
        BoundHashOperations<String, Object, Object> hashOperations = redisTemplate.boundHashOps(KEY_PREFIX + userInfo.getId());
        String key = cart.getSkuId().toString();
        // 判断是否存在需要删除的商品
        if (hashOperations.hasKey(key)) {
            // 在,更新
            hashOperations.delete(key);
        }
        // 获取购物车Map中所有Cart值集合
        List<Object> cartsJson = hashOperations.values();
        // 如果购物车集合为空
        if (CollectionUtils.isEmpty(cartsJson)) {
            return null;
        }
        // 把List<Object>集合转化为List<Cart>
        return cartsJson.stream().map(cartJson -> JsonUtils.parse(cartJson.toString(), Cart.class)).collect(Collectors.toList());
    }
}
