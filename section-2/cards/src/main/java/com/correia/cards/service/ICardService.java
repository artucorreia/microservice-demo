package com.correia.cards.service;

import com.correia.cards.model.Card;

public interface ICardService {
  void createCard(String phoneNumber);

  Card findByPhoneNumber(String phoneNumber);

  void deleteCard(String phoneNumber);
}
