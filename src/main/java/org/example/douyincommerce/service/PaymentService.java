package org.example.douyincommerce.service;

import org.example.douyincommerce.pojo.ChargeReq;
import org.example.douyincommerce.pojo.ChargeResp;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public ChargeResp charge(ChargeReq request){
        //模拟支付逻辑
        ChargeResp response=new ChargeResp();
        response.setTransactionId("TX123");
        return response;
    }
}
