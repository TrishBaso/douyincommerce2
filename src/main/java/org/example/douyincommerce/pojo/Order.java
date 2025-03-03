package org.example.douyincommerce.pojo;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class Order {
    private String orderId;
    private Long userId;
    private String userCurrency;
    private List<OrderItem> orderItems;
    private String email;
    private Timestamp createdAt;
}
