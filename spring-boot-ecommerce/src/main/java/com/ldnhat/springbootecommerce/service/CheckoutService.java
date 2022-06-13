package com.ldnhat.springbootecommerce.service;

import com.ldnhat.springbootecommerce.dto.Purchase;
import com.ldnhat.springbootecommerce.dto.PurchaseResponse;
import org.springframework.stereotype.Service;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
