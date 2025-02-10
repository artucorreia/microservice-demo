package com.correia.loans.dto.response;

public class LoanDTO {

  private Long id;
  private String phoneNumber;
  private String loanNumber;
  private String loanType;
  private Integer totalLoan;
  private Integer amountPaid;
  private Integer outstandingAmount;

  public LoanDTO(Long id, String phoneNumber, String loanNumber, String loanType, Integer totalLoan, Integer amountPaid,
      Integer outstandingAmount) {
    this.id = id;
    this.phoneNumber = phoneNumber;
    this.loanNumber = loanNumber;
    this.loanType = loanType;
    this.totalLoan = totalLoan;
    this.amountPaid = amountPaid;
    this.outstandingAmount = outstandingAmount;
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

  public String getLoanNumber() {
    return loanNumber;
  }

  public void setLoanNumber(String loanNumber) {
    this.loanNumber = loanNumber;
  }

  public String getLoanType() {
    return loanType;
  }

  public void setLoanType(String loanType) {
    this.loanType = loanType;
  }

  public Integer getTotalLoan() {
    return totalLoan;
  }

  public void setTotalLoan(Integer totalLoan) {
    this.totalLoan = totalLoan;
  }

  public Integer getAmountPaid() {
    return amountPaid;
  }

  public void setAmountPaid(Integer amountPaid) {
    this.amountPaid = amountPaid;
  }

  public Integer getOutstandingAmount() {
    return outstandingAmount;
  }

  public void setOutstandingAmount(Integer outstandingAmount) {
    this.outstandingAmount = outstandingAmount;
  }

}
