package com.correia.loans.service.impl;

import com.correia.loans.contant.LoanConstant;
import com.correia.loans.exception.LoanAlreadyExistisException;
import com.correia.loans.exception.ResourceNotFoundException;
import com.correia.loans.model.Loan;
import com.correia.loans.repository.LoanRepository;
import com.correia.loans.service.ILoanService;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoanServiceImpl implements ILoanService {

  private LoanRepository loanRepository;

  @Autowired
  public LoanServiceImpl(LoanRepository loanRepository) {
    this.loanRepository = loanRepository;
  }

  @Override
  public Loan findByPhoneNumber(String phoneNumber) {
    return loanRepository.findByPhoneNumber(phoneNumber)
        .orElseThrow(() -> new ResourceNotFoundException("Loan", "phone number", phoneNumber));
  }

  @Transactional(rollbackFor = Exception.class)
  @Override
  public void createLoan(String phoneNumber) {
    Optional<Loan> optionalLoan = loanRepository.findByPhoneNumber(phoneNumber);
    if (optionalLoan.isPresent())
      throw new LoanAlreadyExistisException("Loan already registered with given mobileNumber " + phoneNumber);
    Loan loan = new Loan();
    long randomLoanNumber = 100000000000L + new Random().nextInt(900000000);
    loan.setLoanNumber(Long.toString(randomLoanNumber));
    loan.setPhoneNumber(phoneNumber);
    loan.setLoanType(LoanConstant.HOME_LOAN);
    loan.setTotalLoan(LoanConstant.NEW_LOAN_LIMIT);
    loan.setAmountPaid(0);
    loan.setOutstandingAmount(LoanConstant.NEW_LOAN_LIMIT);
    loanRepository.save(loan);
  }

  @Transactional(rollbackFor = Exception.class)
  @Modifying
  @Override
  public void deleteLoan(String phoneNumber) {
    Loan loan = findByPhoneNumber(phoneNumber);
    loanRepository.delete(loan);
  }

}
