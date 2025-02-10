package com.correia.cards.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.correia.cards.constant.CardConstant;
import com.correia.cards.dto.CardDTO;
import com.correia.cards.dto.ResponseDTO;
import com.correia.cards.mapper.CardMapper;
import com.correia.cards.model.Card;
import com.correia.cards.service.ICardService;

import jakarta.validation.constraints.Pattern;

@RestController
@RequestMapping("/api/cards")
public class CardController {

  @Autowired
  private ICardService iCardService;

  @Autowired
  private CardMapper cardMapper;

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<CardDTO> findByPhoneNumber(@PathVariable String phoneNumber) {
    Card card = iCardService.findByPhoneNumber(phoneNumber);
    return ResponseEntity.ok(cardMapper.toDTO(card));
  }

  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ResponseDTO> createCard(
      @RequestParam(required = true) @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits") String phoneNumber) {
    iCardService.createCard(phoneNumber);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(new ResponseDTO(CardConstant.STATUS_201, CardConstant.MESSAGE_201));
  }

  @DeleteMapping(value = "/{phoneNumber}")
  public ResponseEntity<ResponseDTO> deleteByPhoneNumber(@PathVariable String phoneNumber) {
    iCardService.deleteCard(phoneNumber);
    return ResponseEntity.status(HttpStatus.NO_CONTENT)
        .body(new ResponseDTO(CardConstant.STATUS_200, CardConstant.MESSAGE_200));
  }

}
