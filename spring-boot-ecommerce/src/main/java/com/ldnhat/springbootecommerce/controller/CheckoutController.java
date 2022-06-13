package com.ldnhat.springbootecommerce.controller;

import com.ldnhat.springbootecommerce.dto.Purchase;
import com.ldnhat.springbootecommerce.dto.PurchaseResponse;
import com.ldnhat.springbootecommerce.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    @Autowired
    private CheckoutService checkoutService;

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase){

        return checkoutService.placeOrder(purchase);
    }
}
