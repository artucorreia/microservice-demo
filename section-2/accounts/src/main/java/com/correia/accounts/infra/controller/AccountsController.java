package com.correia.accounts.infra.controller;

import com.correia.accounts.application.usecases.CreateAccountUseCase;
import com.correia.accounts.application.usecases.DeleteAccountUseCase;
import com.correia.accounts.application.usecases.FindAccountByCustomerIdUseCase;
import com.correia.accounts.application.usecases.FindCustomerByPhoneNumberUseCase;
import com.correia.accounts.application.usecases.UpdateAccountUseCase;
import com.correia.accounts.domain.entity.Account;
import com.correia.accounts.domain.entity.Customer;
import com.correia.accounts.infra.controller.constant.AccountConstant;
import com.correia.accounts.infra.controller.dto.request.CreateCustomerDTO;
import com.correia.accounts.infra.controller.dto.request.UpdateCustomerDTO;
import com.correia.accounts.infra.controller.dto.response.AccountDTO;
import com.correia.accounts.infra.controller.dto.response.CustomerDetailsDTO;
import com.correia.accounts.infra.controller.dto.response.ResponseDTO;
import com.correia.accounts.infra.controller.mapper.AccountMapper;
import com.correia.accounts.infra.controller.mapper.CustomerMapper;

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

  private final FindCustomerByPhoneNumberUseCase findCustomerByPhoneNumberUseCase;
  private final FindAccountByCustomerIdUseCase findAccountByCustomerIdUseCase;
  private final CreateAccountUseCase createAccountUseCase;
  private final UpdateAccountUseCase updateAccountUseCase;
  private final DeleteAccountUseCase deleteAccountUseCase;
  private final CustomerMapper customerMapper;
  private final AccountMapper accountMapper;

  public AccountsController(FindCustomerByPhoneNumberUseCase findCustomerByPhoneNumberUseCase,
      FindAccountByCustomerIdUseCase findAccountByCustomerIdUseCase, CreateAccountUseCase createAccountUseCase,
      UpdateAccountUseCase updateAccountUseCase, DeleteAccountUseCase deleteAccountUseCase,
      CustomerMapper customerMapper, AccountMapper accountMapper) {
    this.findCustomerByPhoneNumberUseCase = findCustomerByPhoneNumberUseCase;
    this.findAccountByCustomerIdUseCase = findAccountByCustomerIdUseCase;
    this.createAccountUseCase = createAccountUseCase;
    this.updateAccountUseCase = updateAccountUseCase;
    this.deleteAccountUseCase = deleteAccountUseCase;
    this.customerMapper = customerMapper;
    this.accountMapper = accountMapper;
  }

  @GetMapping(value = "/{phoneNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<CustomerDetailsDTO> findByPhoneNumber(@PathVariable String phoneNumber) {
    Customer customer = findCustomerByPhoneNumberUseCase.find(phoneNumber);
    Account account = findAccountByCustomerIdUseCase.find(customer.getId());

    CustomerDetailsDTO customerDetailsDTO = customerMapper.toDetailsDTO(customer);
    AccountDTO accountDTO = accountMapper.toDTO(account);
    customerDetailsDTO.setAccountDTO(accountDTO);
    return ResponseEntity.ok(customerDetailsDTO);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ResponseDTO> createAccount(@Valid @RequestBody CreateCustomerDTO createCustomerDTO) {
    Customer customer = customerMapper.toDomain(createCustomerDTO);
    createAccountUseCase.create(customer);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(new ResponseDTO(AccountConstant.STATUS_201, AccountConstant.MESSAGE_201));
  }

  @PutMapping(value = "/{phoneNumber}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ResponseDTO> updateAccount(@PathVariable String phoneNumber,
      @Valid @RequestBody UpdateCustomerDTO updateCustomerDTO) {

    Customer customer = findCustomerByPhoneNumberUseCase.find(phoneNumber);
    updateAccountUseCase.update(customer, updateCustomerDTO.getName(), updateCustomerDTO.getEmail(),
        updateCustomerDTO.getPhoneNumber());
    return ResponseEntity.status(HttpStatus.OK)
        .body(new ResponseDTO(AccountConstant.STATUS_200, AccountConstant.MESSAGE_200));
  }

  @DeleteMapping(value = "/{phoneNumber}")
  public ResponseEntity<ResponseDTO> deleteAccount(@PathVariable String phoneNumber) {
    deleteAccountUseCase.delete(phoneNumber);
    return ResponseEntity.status(HttpStatus.NO_CONTENT)
        .body(new ResponseDTO(AccountConstant.STATUS_200, AccountConstant.MESSAGE_200));
  }

}
