package com.correia.loans.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "loans")
public class Loan extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "phone_number", length = 15, nullable = false)
  private String phoneNumber;

  @Column(name = "loan_number", length = 100, nullable = false)
  private String loanNumber;

  @Column(name = "loan_type", length = 100, nullable = false)
  private String loanType;

  @Column(name = "total_loan", nullable = false)
  private Integer totalLoan;

  @Column(name = "aumount_paid", nullable = false)
  private Integer amountPaid;

  @Column(name = "outstanding_amount", nullable = false)
  private Integer outstandingAmount;

  public Loan() {
  }

  public Loan(LocalDateTime createdAt, String createdBy, LocalDateTime updatedAt, String updatedBy, Long id,
      String phoneNumber, String loanNumber, String loanType, Integer totalLoan, Integer amountPaid,
      Integer outstandingAmount) {
    super(createdAt, createdBy, updatedAt, updatedBy);
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
    Loan other = (Loan) obj;
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
