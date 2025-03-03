package org.example.douyincommerce.pojo;

import lombok.Data;

import java.util.List;

@Data
public class PlaceOrderReq {
    private Long userId;
    private String userCurrency;
    private List<OrderItem> orderItems;
    private String email;

}
