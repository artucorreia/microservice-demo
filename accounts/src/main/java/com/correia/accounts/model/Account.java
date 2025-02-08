package com.correia.accounts.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account extends BaseEntity {

  @Id
  @Column(name = "account_number", updatable = false, nullable = false)
  private Long accountNumber;

  @Column(name = "account_type", nullable = false)
  private String accountType;

  @Column(name = "branch_address", nullable = false)
  private String branchAddress;

  @Column(name = "customer_id", nullable = false)
  private Long customerId;

  public Account() {
  }

  public Account(LocalDateTime createdAt, String createdBy, LocalDateTime updatedAt, String updatedBy,
      Long accountNumber, String accountType, String branchAddress, Long customerId) {
    super(createdAt, createdBy, updatedAt, updatedBy);
    this.accountNumber = accountNumber;
    this.accountType = accountType;
    this.branchAddress = branchAddress;
    this.customerId = customerId;
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

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
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
    Account other = (Account) obj;
    if (accountNumber == null) {
      if (other.accountNumber != null) {
        return false;
      }
    } else if (!accountNumber.equals(other.accountNumber)) {
      return false;
    }
    return true;
  }

}
