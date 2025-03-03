package org.example.douyincommerce.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Cart {
    private Long id; //购物车id
    private Long userId;    //用户id
    private List<CartItem> items;  //购物车商品数组
}
