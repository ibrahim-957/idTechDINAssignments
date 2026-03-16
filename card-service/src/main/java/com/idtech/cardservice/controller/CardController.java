package com.idtech.cardservice.controller;

import com.idtech.cardservice.entity.Card;
import com.idtech.cardservice.model.dtos.request.CreateCardRequest;
import com.idtech.cardservice.model.dtos.request.IncreaseBalanceRequest;
import com.idtech.cardservice.model.dtos.request.UpdateExpiryRequest;
import com.idtech.cardservice.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/cards")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    @PostMapping
    public ResponseEntity<Card> createCard(@RequestBody CreateCardRequest request) {
        Card card = cardService.createCard(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(card);
    }

    @PutMapping("/{id}/block")
    public ResponseEntity<Card> blockCard(@PathVariable Long id){
        Card card = cardService.blockCard(id);
        return ResponseEntity.ok(card);
    }

    @PutMapping("/{id}/unblock")
    public ResponseEntity<Card> unblockCard(@PathVariable Long id) {
        Card card = cardService.unblockCard(id);
        return ResponseEntity.ok(card);
    }

    @PutMapping("/{id}/expiry-date")
    public ResponseEntity<Card> updateExpiryDate(
            @PathVariable Long id,
            @RequestBody UpdateExpiryRequest request) {
        Card card = cardService.updateExpiryDate(id, request);
        return ResponseEntity.ok(card);
    }

    @PutMapping("/{id}/balance")
    public ResponseEntity<Card> increaseBalance(
            @PathVariable Long id,
            @RequestBody IncreaseBalanceRequest request) {
        Card card = cardService.increaseBalance(id, request);
        return ResponseEntity.ok(card);
    }
}
