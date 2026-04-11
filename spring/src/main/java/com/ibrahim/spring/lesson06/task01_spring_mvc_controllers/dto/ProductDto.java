package com.ibrahim.spring.lesson06.task01_spring_mvc_controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String category;
    private boolean isActive;
    private LocalDateTime createdAt;
}
