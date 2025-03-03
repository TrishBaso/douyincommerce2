package org.example.douyincommerce.pojo;

import lombok.Data;

@Data
public class CheckoutReq {
    private Long userId;
    private String firstname;
    private String lastname;
    private String email;
    private Address address;
    private CreditCardInfo creditCard;

}
