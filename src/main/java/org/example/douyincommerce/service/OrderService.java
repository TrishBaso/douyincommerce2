package org.example.douyincommerce.service;

import org.example.douyincommerce.mapper.OrderMapper;
import org.example.douyincommerce.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;

    public Order placeOrder(PlaceOrderReq request){
//        String orderId= UUID.randomUUID().toString();
        Order order=new Order();
//        order.setOrderId(orderId);
        order.setUserId(request.getUserId());
        order.setUserCurrency(request.getUserCurrency());
        order.setEmail(request.getEmail());
//        order.setCreatedAt(System.currentTimeMillis());
        order.setCreatedAt(new java.sql.Timestamp(System.currentTimeMillis()));
        orderMapper.placeOrder(order);
        return order;
    }

    public List<Order>listOrders(Long userId){
        return orderMapper.listOrders(userId);
    }
}
