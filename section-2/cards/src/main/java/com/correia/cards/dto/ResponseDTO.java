package com.correia.cards.dto;

public class ResponseDTO {

  private String statusCode;
  private String statusMessage;

  public ResponseDTO(String statusCode, String statusMessage) {
    this.statusCode = statusCode;
    this.statusMessage = statusMessage;
  }

  public String getStatusCode() {
    return statusCode;
  }

  public String getStatusMessage() {
    return statusMessage;
  }

}
