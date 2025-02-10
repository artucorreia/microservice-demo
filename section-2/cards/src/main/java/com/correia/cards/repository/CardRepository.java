package com.correia.cards.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.correia.cards.model.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
  Optional<Card> findByPhoneNumber(String phoneNumber);
}
