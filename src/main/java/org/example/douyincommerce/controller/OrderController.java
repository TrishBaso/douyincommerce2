package org.example.douyincommerce.controller;

import org.example.douyincommerce.pojo.Order;
import org.example.douyincommerce.pojo.PlaceOrderReq;
import org.example.douyincommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/placeOrder")
    public Order placeOrder(@RequestBody PlaceOrderReq request){
        return orderService.placeOrder(request);
    }

    @GetMapping("listOrders")
    public List<Order> listOrders(@RequestParam Long userId){
        return orderService.listOrders(userId);
    }


}
