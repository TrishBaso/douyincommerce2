package org.example.douyincommerce.service;

import org.example.douyincommerce.mapper.CartMapper;
import org.example.douyincommerce.pojo.AddItemRequ;
import org.example.douyincommerce.pojo.Cart;
import org.example.douyincommerce.pojo.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartMapper cartMapper;
//    public void addItem(AddItemRequ request){
//        cartMapper.addItem(request.getUserId(),request.getItem());
//    }
//
//    public Cart getCart(Long userId){
//        return cartMapper.getCart(userId);
//    }
//
//    public void emptyCart(Long userId){
//        cartMapper.emptyCart(userId);
//    }


    public Cart getCart(Long userId) {
        // 查询购物车基本信息
        Cart cart = cartMapper.getCartByUserId(userId);
        if (cart != null) {
            // 查询购物车中的商品列表
            List<CartItem> items = cartMapper.getCartItemsByCartId(cart.getId());
            cart.setItems(items);
        }
        return cart;
    }
    public void addItem(AddItemRequ request) {
        // 查询用户的购物车
        Cart cart = cartMapper.getCartByUserId(request.getUserId());
        if (cart == null) {
            // 如果购物车不存在，创建新的购物车
            cart = new Cart();
            cart.setUserId(request.getUserId());
            cartMapper.createCart(cart); // 需要实现 createCart 方法
        }

        // 创建商品项
        CartItem cartItem = new CartItem();
        cartItem.setCartId(cart.getId());
        cartItem.setProductId(request.getItem().getProductId());
        cartItem.setQuantity(request.getItem().getQuantity());

        // 插入商品项
        cartMapper.addCartItem(cartItem);
    }

    public void emptyCart(Long userId) {
        // 查询用户的购物车
        Cart cart = cartMapper.getCartByUserId(userId);
        if (cart != null) {
            // 清空购物车中的商品
            cartMapper.emptyCart(cart.getId());
        }
    }
}
