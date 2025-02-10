package com.correia.accounts.controller;

import com.correia.accounts.constant.AccountConstant;
import com.correia.accounts.dto.create.CreateCustomerDTO;
import com.correia.accounts.dto.response.AccountDTO;
import com.correia.accounts.dto.response.CustomerDetailsDTO;
import com.correia.accounts.dto.response.ResponseDTO;
import com.correia.accounts.dto.update.UpdateCustomerDTO;
import com.correia.accounts.mapper.AccountMapper;
import com.correia.accounts.mapper.CustomerMapper;
import com.correia.accounts.model.Account;
import com.correia.accounts.model.Customer;
import com.correia.accounts.service.IAccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/accounts")
public class AccountsController {

  @Autowired
  private IAccountService iAccountService;

  @Autowired
  private CustomerMapper customerMapper;

  @Autowired
  private AccountMapper accountMapper;

  @GetMapping(value = "/{phoneNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<CustomerDetailsDTO> findByPhoneNumber(@PathVariable String phoneNumber) {
    Customer customer = iAccountService.findCustomerByPhoneNumber(phoneNumber);
    Account account = iAccountService.findAccountByCustomerId(customer.getId());

    CustomerDetailsDTO customerDetailsDTO = customerMapper.toDetailsDTO(customer);
    AccountDTO accountDTO = accountMapper.toDTO(account);
    customerDetailsDTO.setAccountDTO(accountDTO);
    return ResponseEntity.ok(customerDetailsDTO);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ResponseDTO> createAccount(@Valid @RequestBody CreateCustomerDTO createCustomerDTO) {
    Customer customer = customerMapper.toEntity(createCustomerDTO);
    iAccountService.createAccount(customer);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(new ResponseDTO(AccountConstant.STATUS_201, AccountConstant.MESSAGE_201));
  }

  @PutMapping(value = "/{phoneNumber}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ResponseDTO> updateAccount(@PathVariable String phoneNumber,
      @Valid @RequestBody UpdateCustomerDTO updateCustomerDTO) {

    Customer customer = iAccountService.findCustomerByPhoneNumber(phoneNumber);
    iAccountService.updateAccount(customer, updateCustomerDTO.getName(), updateCustomerDTO.getEmail(),
        updateCustomerDTO.getPhoneNumber());
    return ResponseEntity.status(HttpStatus.OK)
        .body(new ResponseDTO(AccountConstant.STATUS_200, AccountConstant.MESSAGE_200));
  }

  @DeleteMapping(value = "/{phoneNumber}")
  public ResponseEntity<ResponseDTO> deleteAccount(@PathVariable String phoneNumber) {
    iAccountService.deleteAccount(phoneNumber);
    return ResponseEntity.status(HttpStatus.NO_CONTENT)
        .body(new ResponseDTO(AccountConstant.STATUS_200, AccountConstant.MESSAGE_200));
  }

}
