package com.correia.cards.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cards")
public class Card extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "phone_number", length = 15, nullable = false)
  private String phoneNumber;

  @Column(name = "card_number", length = 100, nullable = false)
  private String cardNumber;

  @Column(name = "card_type", length = 100, nullable = false)
  private String cardType;

  @Column(name = "total_limit", nullable = false)
  private Integer totalLimit;

  @Column(name = "amout_used", nullable = false)
  private Integer amountUsed;

  @Column(name = "available_amount", nullable = false)
  private Integer availableAmount;

  public Card() {
  }

  public Card(Long id, String phoneNumber, String cardNumber, String cardType, Integer totalLimit, Integer amountUsed,
      Integer availableAmount, LocalDateTime createdAt, String createdBy, LocalDateTime updatedAt, String updatedBy) {
    super(createdAt, createdBy, updatedAt, updatedBy);
    this.id = id;
    this.phoneNumber = phoneNumber;
    this.cardNumber = cardNumber;
    this.cardType = cardType;
    this.totalLimit = totalLimit;
    this.amountUsed = amountUsed;
    this.availableAmount = availableAmount;

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public String getCardType() {
    return cardType;
  }

  public void setCardType(String cardType) {
    this.cardType = cardType;
  }

  public Integer getTotalLimit() {
    return totalLimit;
  }

  public void setTotalLimit(Integer totalLimit) {
    this.totalLimit = totalLimit;
  }

  public Integer getAmountUsed() {
    return amountUsed;
  }

  public void setAmountUsed(Integer amountUsed) {
    this.amountUsed = amountUsed;
  }

  public Integer getAvailableAmount() {
    return availableAmount;
  }

  public void setAvailableAmount(Integer availableAmount) {
    this.availableAmount = availableAmount;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Card other = (Card) obj;
    if (id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (!id.equals(other.id)) {
      return false;
    }
    return true;
  }
}
