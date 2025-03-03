package org.example.douyincommerce.controller;

import org.example.douyincommerce.pojo.ChargeReq;
import org.example.douyincommerce.pojo.ChargeResp;
import org.example.douyincommerce.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/charge")
    public ChargeResp charge(@RequestBody ChargeReq request){
        return paymentService.charge(request);
    }
}
