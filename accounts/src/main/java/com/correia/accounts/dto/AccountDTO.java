package com.correia.accounts.dto;

public class AccountDTO {
  private Long accountNumber;
  private String accountType;
  private String branchAddress;

  public AccountDTO() {
  }

  public AccountDTO(Long accountNumber, String accountType, String branchAddress) {
    this.accountNumber = accountNumber;
    this.accountType = accountType;
    this.branchAddress = branchAddress;
  }

  public Long getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(Long accountNumber) {
    this.accountNumber = accountNumber;
  }

  public String getAccountType() {
    return accountType;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

  public String getBranchAddress() {
    return branchAddress;
  }

  public void setBranchAddress(String branchAddress) {
    this.branchAddress = branchAddress;
  }

}
