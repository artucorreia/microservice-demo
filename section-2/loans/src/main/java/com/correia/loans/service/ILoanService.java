package com.correia.loans.service;

import com.correia.loans.model.Loan;

public interface ILoanService {

  Loan findByPhoneNumber(String phoneNumber);

  void createLoan(String phoneNumber);

  void deleteLoan(String phoneNumber);
}
