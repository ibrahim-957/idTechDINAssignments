package com.ibrahim.liquibase.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductRequest {
    @Size(max = 255, message = "Name must be at most 255 characters")
    private String name;

    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    @Digits(integer = 8, fraction = 2, message = "Price: up to 8 integer digits and 2 decimals")
    private BigDecimal price;

    @Min(value = 0, message = "Quantity must be 0 or more")
    private Integer quantity;
}
