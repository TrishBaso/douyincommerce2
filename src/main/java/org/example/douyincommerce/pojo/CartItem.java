package org.example.douyincommerce.pojo;

import lombok.Data;

@Data
public class CartItem {
    private int id;//商品项id
    private Long cartId;//购物车id
    private Integer productId;//商品编号
    private Integer quantity;//商品数量
}
