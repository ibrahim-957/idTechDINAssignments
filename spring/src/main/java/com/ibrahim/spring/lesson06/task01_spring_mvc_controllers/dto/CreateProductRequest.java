package com.ibrahim.spring.lesson06.task01_spring_mvc_controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest {
    private String name;
    private String description;
    private String category;
    private BigDecimal price;
}
