package org.example.douyincommerce.pojo;

import lombok.Data;

@Data
public class ChargeReq {
    private float amount;
    private CreditCardInfo creditCard;
    private String orderId;
    private Long userId;

}
