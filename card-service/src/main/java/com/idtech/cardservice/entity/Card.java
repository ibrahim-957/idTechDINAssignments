package com.idtech.cardservice.entity;

import com.idtech.cardservice.model.enums.CardStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Card {
    private Long id;
    private String holderName;
    private String pan;
    private String cvv;
    private LocalDate expiryDate;
    private BigDecimal balance;
    private CardStatus status;
}
