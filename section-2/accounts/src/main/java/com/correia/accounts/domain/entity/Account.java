package com.correia.accounts.domain.entity;

import java.time.LocalDateTime;

public class Account extends Base {

    private Long accountNumber;
    private String accountType;
    private String branchAddress;
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
}