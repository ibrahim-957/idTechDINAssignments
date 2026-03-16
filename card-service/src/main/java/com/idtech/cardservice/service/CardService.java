package com.idtech.cardservice.service;

import com.idtech.cardservice.entity.Card;
import com.idtech.cardservice.model.dtos.request.CreateCardRequest;
import com.idtech.cardservice.model.dtos.request.IncreaseBalanceRequest;
import com.idtech.cardservice.model.dtos.request.UpdateExpiryRequest;
import com.idtech.cardservice.model.enums.CardStatus;
import com.idtech.cardservice.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;

    public Card createCard(CreateCardRequest request){
        Card card = Card.builder()
                .holderName(request.getHolderName())
                .pan(request.getPan())
                .expiryDate(request.getExpiryDate())
                .cvv(request.getCvv())
                .balance(request.getBalance() != null ? request.getBalance() : BigDecimal.ZERO)
                .status(CardStatus.ACTIVE)
                .build();
        return cardRepository.save(card);
    }

    public Card blockCard(Long id) {
        Card card = findCardById(id);

        if (card.getStatus() == CardStatus.BLOCKED) {
            throw new IllegalStateException("Card is already blocked");
        }

        cardRepository.updateStatus(id, CardStatus.BLOCKED);
        card.setStatus(CardStatus.BLOCKED);
        return card;
    }

    public Card unblockCard(Long id) {
        Card card = findCardById(id);

        if (card.getStatus() == CardStatus.STOLEN) {
            throw new IllegalStateException("Stolen card cannot be unblocked");
        }

        if (card.getStatus() == CardStatus.ACTIVE) {
            throw new IllegalStateException("Card is already active");
        }

        cardRepository.updateStatus(id, CardStatus.ACTIVE);
        card.setStatus(CardStatus.ACTIVE);
        return card;
    }

    public Card updateExpiryDate(Long id, UpdateExpiryRequest request){
        Card card = findCardById(id);
        cardRepository.updateExpiryDate(id, request.getExpiryDate());
        card.setExpiryDate(request.getExpiryDate());
        return card;
    }

    public Card increaseBalance(Long id, IncreaseBalanceRequest request){
        if (request.getAmount() == null || request.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalStateException("Amount must be greater than 0");
        }
        Card card = findCardById(id);
        if (card.getStatus() != CardStatus.ACTIVE) {
            throw new IllegalStateException("Cannot increase balance of a " + card.getStatus() + " card");
        }
        cardRepository.increaseBalance(id, request.getAmount());
        card.setBalance(card.getBalance().add(request.getAmount()));
        return card;
    }

    private Card findCardById(Long id){
        return cardRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Card not found"));
    }
}
