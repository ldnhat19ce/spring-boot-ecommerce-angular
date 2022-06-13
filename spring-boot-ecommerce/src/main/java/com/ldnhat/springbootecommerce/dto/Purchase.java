package com.ldnhat.springbootecommerce.dto;

import com.ldnhat.springbootecommerce.entity.Address;
import com.ldnhat.springbootecommerce.entity.CustomerEntity;
import com.ldnhat.springbootecommerce.entity.OrderItem;
import com.ldnhat.springbootecommerce.entity.Orders;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Set;

@Data
@Component
public class Purchase {

    private CustomerEntity customerEntity;
    private Address shippingAddress;
    private Address billingAddress;
    private Orders order;
    private Set<OrderItem> orderItems;
}
