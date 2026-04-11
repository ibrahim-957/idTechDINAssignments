package com.ibrahim.simpleshop.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductRequest {
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stockQuantity;
}
