package com.correia.cards.mapper;

import org.mapstruct.Mapper;

import com.correia.cards.dto.CardDTO;
import com.correia.cards.model.Card;

@Mapper
public interface CardMapper {
  Card toEntity(CardDTO cardDTO);

  CardDTO toDTO(Card card);
}
