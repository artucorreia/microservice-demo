package com.correia.cards.service.impl;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.correia.cards.constant.CardConstant;
import com.correia.cards.exception.CardAlreadyExistisException;
import com.correia.cards.exception.ResourceNotFoundException;
import com.correia.cards.model.Card;
import com.correia.cards.repository.CardRepository;
import com.correia.cards.service.ICardService;

@Service
public class CardServiceImpl implements ICardService {

  @Autowired
  private CardRepository cardRepository;

  @Override
  public void createCard(String phoneNumber) {
    Optional<Card> optionalCard = cardRepository.findByPhoneNumber(phoneNumber);
    if (optionalCard.isPresent())
      throw new CardAlreadyExistisException("Card already registered with given mobileNumber " + phoneNumber);

    Card newCard = new Card();
    long randomCardNumber = 100000000000L + new Random().nextInt(900000000);
    newCard.setCardNumber(Long.toString(randomCardNumber));
    newCard.setPhoneNumber(phoneNumber);
    newCard.setCardType(CardConstant.CREDIT_CARD);
    newCard.setTotalLimit(CardConstant.NEW_CARD_LIMIT);
    newCard.setAmountUsed(0);
    newCard.setAvailableAmount(CardConstant.NEW_CARD_LIMIT);
    cardRepository.save(newCard);
  }

  @Override
  public Card findByPhoneNumber(String phoneNumber) {
    return cardRepository.findByPhoneNumber(phoneNumber)
        .orElseThrow(() -> new ResourceNotFoundException("Card", "phone number", phoneNumber));
  }

  @Override
  public void deleteCard(String phoneNumber) {
    Card card = findByPhoneNumber(phoneNumber);
    cardRepository.delete(card);
  }

}
