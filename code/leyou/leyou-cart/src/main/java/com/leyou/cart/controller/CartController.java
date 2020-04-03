package com.leyou.cart.controller;

import com.leyou.cart.pojo.Cart;
import com.leyou.cart.service.impl.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lgl
 * @Description:
 * @date 2020/3/10 4:00 下午
 */
@RestController
public class CartController {
    @Autowired
    private CartServiceImpl cartService;

    /**
     * 加入购物车方法
     *
     * @param cart
     * @return
     */
    @PostMapping
    public ResponseEntity<Void> addCart(@RequestBody Cart cart) {
        cartService.addCart(cart);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 根据登录信息查询购物车
     *
     * @return
     */
    @GetMapping
    public ResponseEntity<List<Cart>> queryCats() {
        List<Cart> carts = cartService.queryCats();
        if (CollectionUtils.isEmpty(carts)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carts);
    }

    /**
     * 根据skuId和num修改商品信息
     *
     * @param cart
     * @return
     */
    @PutMapping
    public ResponseEntity<Void> updateCart(@RequestBody Cart cart) {
        cartService.updateCart(cart);
        return ResponseEntity.noContent().build();
    }

    /**
     * 删除商品
     *
     * @param cart
     * @return
     */
    @DeleteMapping
    public ResponseEntity<List<Cart>> deleteCart(@RequestBody Cart cart) {
        List<Cart> carts = cartService.deleteCart(cart);
        if (CollectionUtils.isEmpty(carts)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carts);
    }
}
