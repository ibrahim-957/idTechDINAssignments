package com.idtech.cardservice.model.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCardRequest {
    private String holderName;
    private String pan;
    private String cvv;
    private LocalDate expiryDate;
    private BigDecimal balance;
}
