package com.correia.loans.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.correia.loans.contant.LoanConstant;
import com.correia.loans.dto.response.LoanDTO;
import com.correia.loans.dto.response.ResponseDTO;
import com.correia.loans.mapper.LoanMapper;
import com.correia.loans.model.Loan;
import com.correia.loans.service.ILoanService;

import jakarta.validation.constraints.Pattern;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

  @Autowired
  private ILoanService iLoanService;

  @Autowired
  private LoanMapper mapper;

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<LoanDTO> findByPhoneNumber(@PathVariable String phoneNumber) {
    Loan loan = iLoanService.findByPhoneNumber(phoneNumber);
    return ResponseEntity.ok(mapper.toDTO(loan));
  }

  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ResponseDTO> createLoan(
      @RequestParam(required = true) @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits") String phoneNumber) {
    iLoanService.createLoan(phoneNumber);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(new ResponseDTO(LoanConstant.STATUS_201, LoanConstant.MESSAGE_201));
  }

  @DeleteMapping(value = "/{phoneNumber}")
  public ResponseEntity<ResponseDTO> deleteByPhoneNumber(@PathVariable String phoneNumber) {
    iLoanService.deleteLoan(phoneNumber);
    return ResponseEntity.status(HttpStatus.NO_CONTENT)
        .body(new ResponseDTO(LoanConstant.STATUS_200, LoanConstant.MESSAGE_200));
  }

}
