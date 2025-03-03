package org.example.douyincommerce.pojo;

import lombok.Data;

@Data
public class CreditCardInfo {
    private String creditCardNumber;
    private int creditCardCvv;
    private int creditCardExpirationYear;
    private int creditCardExpirationMonth;


}
