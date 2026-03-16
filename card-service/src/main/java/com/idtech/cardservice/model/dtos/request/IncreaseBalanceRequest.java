package com.idtech.cardservice.model.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IncreaseBalanceRequest {
    private BigDecimal amount;
}
