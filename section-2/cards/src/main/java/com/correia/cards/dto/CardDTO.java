package com.correia.cards.dto;

public class CardDTO {
  private String mobileNumber;
  private String cardNumber;
  private String cardType;
  private int totalLimit;
  private int amountUsed;
  private int availableAmount;

  public CardDTO() {
  }

  public CardDTO(String mobileNumber, String cardNumber, String cardType, int totalLimit, int amountUsed,
      int availableAmount) {
    this.mobileNumber = mobileNumber;
    this.cardNumber = cardNumber;
    this.cardType = cardType;
    this.totalLimit = totalLimit;
    this.amountUsed = amountUsed;
    this.availableAmount = availableAmount;
  }

  public String getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
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

  public int getTotalLimit() {
    return totalLimit;
  }

  public void setTotalLimit(int totalLimit) {
    this.totalLimit = totalLimit;
  }

  public int getAmountUsed() {
    return amountUsed;
  }

  public void setAmountUsed(int amountUsed) {
    this.amountUsed = amountUsed;
  }

  public int getAvailableAmount() {
    return availableAmount;
  }

  public void setAvailableAmount(int availableAmount) {
    this.availableAmount = availableAmount;
  }

}
