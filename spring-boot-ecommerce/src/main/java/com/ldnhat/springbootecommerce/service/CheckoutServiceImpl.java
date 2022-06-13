package com.ldnhat.springbootecommerce.service;

import com.ldnhat.springbootecommerce.dto.Purchase;
import com.ldnhat.springbootecommerce.dto.PurchaseResponse;
import com.ldnhat.springbootecommerce.entity.CustomerEntity;
import com.ldnhat.springbootecommerce.entity.OrderItem;
import com.ldnhat.springbootecommerce.entity.Orders;
import com.ldnhat.springbootecommerce.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        // retrieve the order info from dto
        Orders order = purchase.getOrder();

        // generate tracking number
        // tạo ra mã tracking
        String orderTrackingNumber = generateTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        //populate order with orderItem
        Set<OrderItem> orderItems = purchase.getOrderItems();
        // item -> order.add(item)
        orderItems.forEach(order::add);

        //populate order with billingAddress and shippingAddress
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        // populate customer with order
        CustomerEntity customerEntity = purchase.getCustomerEntity();

        // check if this is existing customer
        String email = customerEntity.getEmail();
        CustomerEntity customerFromDB = customerRepository.findByEmail(email);
        if (customerFromDB != null){
            customerEntity = customerFromDB;
        }
        customerEntity.add(order);
        //save to the database
        customerRepository.save(customerEntity);
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateTrackingNumber(){
        //generate a random UUID number

        return UUID.randomUUID().toString();
    }
}
