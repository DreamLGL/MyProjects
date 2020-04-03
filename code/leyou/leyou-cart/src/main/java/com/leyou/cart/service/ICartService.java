package com.leyou.cart.service;

import com.leyou.cart.pojo.Cart;

import java.util.List;

/**
 * @author lgl
 * @Description:
 * @date 2020/3/10 4:01 下午
 */
public interface ICartService {
    /**
     * 加入购物车
     *
     * @param cart
     */
    void addCart(Cart cart);

    /**
     * 根据登录信息查询购物车
     *
     * @return
     */
    List<Cart> queryCats();

    /**
     * 根据skuId和num修改商品信息
     *
     * @param cart
     */
    void updateCart(Cart cart);

    /**
     * 删除商品
     *
     * @param cart
     * @return
     */
    List<Cart> deleteCart(Cart cart);
}
