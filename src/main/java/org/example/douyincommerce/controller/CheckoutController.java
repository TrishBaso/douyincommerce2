package org.example.douyincommerce.controller;

import org.example.douyincommerce.pojo.CheckoutReq;
import org.example.douyincommerce.pojo.CheckoutResp;
import org.example.douyincommerce.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("checkout")
public class CheckoutController {

    @Autowired
    private CheckoutService checkoutService;

    @PostMapping("/checkout")
    public CheckoutResp checkout(@RequestBody CheckoutReq request){
        return checkoutService.checkout(request);
    }
}
