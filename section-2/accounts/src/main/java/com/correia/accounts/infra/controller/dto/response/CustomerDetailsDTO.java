package com.correia.accounts.infra.controller.dto.response;

public class CustomerDetailsDTO {
  private String name;
  private String email;
  private String phoneNumber;
  private AccountDTO accountDTO;

  public CustomerDetailsDTO() {
  }

  public CustomerDetailsDTO(String name, String email, String phoneNumber,
      com.correia.accounts.infra.controller.dto.response.AccountDTO accountDTO) {
    this.name = name;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.accountDTO = accountDTO;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public AccountDTO getAccountDTO() {
    return accountDTO;
  }

  public void setAccountDTO(AccountDTO accountDTO) {
    this.accountDTO = accountDTO;
  }

}
