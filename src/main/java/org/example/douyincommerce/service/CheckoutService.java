package org.example.douyincommerce.service;

import org.example.douyincommerce.pojo.CheckoutReq;
import org.example.douyincommerce.pojo.CheckoutResp;
import org.springframework.stereotype.Service;

@Service
public class CheckoutService {
    public CheckoutResp checkout(CheckoutReq request){
        //调用支付服务完成支付，生成订单
        CheckoutResp response=new CheckoutResp();
        response.setOrderId("ORDER123");
        response.setOrderId("TX123");
        return response;
    }
}
