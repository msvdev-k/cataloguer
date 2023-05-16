package org.cataloguer.mapper;

import org.cataloguer.entity.CardEntity;
import org.cataloguer.openapi.model.Card;
import org.springframework.stereotype.Component;

import java.time.ZoneOffset;


@Component
public class CardMapper {

    public Card entityToModel(CardEntity cardEntity) {
        Card card = new Card();
        card.setId(cardEntity.getId());
        card.setCreationDate(cardEntity.getCreated().atOffset(ZoneOffset.UTC));
        return card;
    }
}
