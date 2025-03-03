package org.example.douyincommerce.pojo;

import lombok.Data;

@Data
public class OrderItem {
    private Integer productId;
    private Integer quantity;
    private float cost;
}
