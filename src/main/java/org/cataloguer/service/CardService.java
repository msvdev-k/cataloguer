package org.cataloguer.service;

import lombok.RequiredArgsConstructor;
import org.cataloguer.entity.CardEntity;
import org.cataloguer.repository.CardRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    public CardEntity newCard() {
        CardEntity card = new CardEntity();
        return cardRepository.save(card);
    }
}
