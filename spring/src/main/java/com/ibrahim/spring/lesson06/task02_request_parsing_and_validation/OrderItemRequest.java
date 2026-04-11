package com.ibrahim.spring.lesson06.task02_request_parsing_and_validation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemRequest {
    private Long productId;
    private int quantity;
    private BigDecimal unitPrice;
}
