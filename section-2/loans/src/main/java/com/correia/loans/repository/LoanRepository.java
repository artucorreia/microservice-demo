package com.correia.loans.repository;

import java.util.Optional;

import com.correia.loans.model.Loan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
  Optional<Loan> findByPhoneNumber(String phoneNumber);
}
