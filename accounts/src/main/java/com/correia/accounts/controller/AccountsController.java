package com.correia.accounts.controller;

import com.correia.accounts.constant.AccountConstant;
import com.correia.accounts.dto.CustomerDTO;
import com.correia.accounts.dto.ResponseDTO;
import com.correia.accounts.service.IAccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class AccountsController {

  @Autowired
  private IAccountService iAccountService;

  @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ResponseDTO> createAccount(@Valid @RequestBody CustomerDTO customerDTO) {
    iAccountService.createAccount(customerDTO);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(new ResponseDTO(AccountConstant.STATUS_201, AccountConstant.MESSAGE_201));
  }
}
