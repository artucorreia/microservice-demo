package com.correia.accounts.service.impl;

import java.util.Optional;
import java.util.Random;

import com.correia.accounts.constant.AccountConstant;
import com.correia.accounts.dto.CustomerDTO;
import com.correia.accounts.exception.CustomerAlreadyExistsException;
import com.correia.accounts.mapper.AccountMapper;
import com.correia.accounts.mapper.CustomerMapper;
import com.correia.accounts.model.Account;
import com.correia.accounts.model.Customer;
import com.correia.accounts.repository.AccountRepository;
import com.correia.accounts.repository.CustomerRepository;
import com.correia.accounts.service.IAccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements IAccountService {

  @Autowired
  private AccountRepository accountRepository;

  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private AccountMapper accountMapper;

  @Autowired
  private CustomerMapper customerMapper;

  @Transactional(rollbackFor = Exception.class)
  @Override
  public void createAccount(CustomerDTO customerDTO) {
    Optional<Customer> optionalCustomer = customerRepository.findByPhoneNumber(customerDTO.getPhoneNumber());

    if (optionalCustomer.isPresent())
      throw new CustomerAlreadyExistsException("Phone number already in use");

    customerDTO.setName(customerDTO.getName().trim());
    customerDTO.setPhoneNumber(customerDTO.getPhoneNumber().trim());

    Customer customer = customerMapper.toEntity(customerDTO);
    customer.setCreatedBy("Anonymous");
    Customer savedCustomer = customerRepository.save(customer);
    accountRepository.save(createNewAccount(savedCustomer));
  }

  @Transactional(rollbackFor = Exception.class)
  private Account createNewAccount(Customer customer) {
    Account account = new Account();
    account.setCustomerId(customer.getId());
    account.setAccountType(AccountConstant.SAVINGS);
    account.setBranchAddress(AccountConstant.ADDRESS);
    long accountNumber = 1000000000L + new Random().nextInt(900000000);
    account.setAccountNumber(accountNumber);
    account.setCreatedBy(customer.getName());
    return account;
  }

}
