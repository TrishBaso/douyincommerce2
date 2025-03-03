package org.example.douyincommerce.controller;

import org.example.douyincommerce.pojo.AddItemRequ;
import org.example.douyincommerce.pojo.Cart;
import org.example.douyincommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;
//
//    @PostMapping  ("/addItem")
//    public void addItem(@RequestBody AddItemRequ request){
//        cartService.addItem(request);
//    }
//
//    @GetMapping("/getCart")
//    public Cart getCart(@RequestParam Long userId){
//        return cartService.getCart(userId);
//    }
//
//    @PostMapping("/emptyCart")
//    public void emptyCart(@RequestParam Long userId){
//        cartService.emptyCart(userId);
//    }

    @GetMapping("/getCart")
    public Cart getCart(@RequestParam Long userId) {
        return cartService.getCart(userId);
    }

    @PostMapping("/addItem")
    public void addItem(@RequestBody AddItemRequ request) {
        cartService.addItem(request);
    }

    @PostMapping("/emptyCart")
    public void emptyCart(@RequestParam Long userId) {
        cartService.emptyCart(userId);
    }
}


