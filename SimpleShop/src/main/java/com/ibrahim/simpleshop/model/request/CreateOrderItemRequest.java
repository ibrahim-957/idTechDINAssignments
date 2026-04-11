package com.ibrahim.simpleshop.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderItemRequest {
    private Long productId;
    private Integer quantity;
}
