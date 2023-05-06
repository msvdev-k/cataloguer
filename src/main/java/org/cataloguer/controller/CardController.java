package org.cataloguer.controller;

import org.cataloguer.openapi.api.CardApi;
import org.cataloguer.openapi.model.Card;
import org.cataloguer.openapi.model.FieldRequest;
import org.cataloguer.openapi.model.FieldResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class CardController implements CardApi {
    @Override
    public ResponseEntity<FieldResponse> addFieldValueToCard(Long cardId, FieldRequest fieldRequest) {
        return CardApi.super.addFieldValueToCard(cardId, fieldRequest);
    }

    @Override
    public ResponseEntity<Card> getCardById(Long cardId) {
        return CardApi.super.getCardById(cardId);
    }

    @Override
    public ResponseEntity<Void> removeCardById(Long cardId) {
        return CardApi.super.removeCardById(cardId);
    }

    @Override
    public ResponseEntity<Void> removeFieldValueFromCard(Long cardId) {
        return CardApi.super.removeFieldValueFromCard(cardId);
    }

    @Override
    public ResponseEntity<FieldResponse> updateFieldValueToCard(Long cardId, FieldRequest fieldRequest) {
        return CardApi.super.updateFieldValueToCard(cardId, fieldRequest);
    }
}
