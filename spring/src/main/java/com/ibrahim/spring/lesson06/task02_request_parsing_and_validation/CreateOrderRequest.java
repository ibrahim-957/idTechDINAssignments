package com.ibrahim.spring.lesson06.task02_request_parsing_and_validation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderRequest {
    private Long customerId;
    private String shippingAddress;
    private List<OrderItemRequest> items;
}
