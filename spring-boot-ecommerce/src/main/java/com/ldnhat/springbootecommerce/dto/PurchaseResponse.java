package com.ldnhat.springbootecommerce.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class PurchaseResponse {
    // lombok data will generate constructor for final fields
    private final String orderTrackingNumber;

}
