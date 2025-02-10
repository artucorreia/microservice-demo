package com.correia.accounts.service.impl;

import java.util.Optional;
import java.util.Random;

import com.correia.accounts.constant.AccountConstant;
import com.correia.accounts.exception.CustomerAlreadyExistsException;
import com.correia.accounts.exception.ResourceNotFoundException;
import com.correia.accounts.model.Account;
import com.correia.accounts.model.Customer;
import com.correia.accounts.repository.AccountRepository;
import com.correia.accounts.repository.CustomerRepository;
import com.correia.accounts.service.IAccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements IAccountService {

  @Autowired
  private AccountRepository accountRepository;

  @Autowired
  private CustomerRepository customerRepository;

  @Override
  public Customer findCustomerByPhoneNumber(String phoneNumber) {
    return customerRepository.findByPhoneNumber(phoneNumber)
        .orElseThrow(() -> new ResourceNotFoundException("Customer", "phone number", phoneNumber));
  }

  @Override
  public Account findAccountByCustomerId(Long customerId) {
    return accountRepository.findByCustomerId(customerId)
        .orElseThrow(() -> new ResourceNotFoundException("Account", "customer id", customerId.toString()));
  }

  @Transactional(rollbackFor = Exception.class)
  @Override
  public void createAccount(Customer customer) {
    Optional<Customer> optionalCustomer = customerRepository.findByPhoneNumber(customer.getPhoneNumber());

    if (optionalCustomer.isPresent())
      throw new CustomerAlreadyExistsException("Phone number already in use");

    customer.setName(customer.getName().trim());
    customer.setPhoneNumber(customer.getPhoneNumber().trim());
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

  @Override
  public void updateAccount(Customer customer, String newName, String newEmail, String newPhoneNumber) {
    Optional<Customer> optionalCustomer = customerRepository.findByPhoneNumber(newPhoneNumber);

    if (optionalCustomer.isPresent())
      throw new CustomerAlreadyExistsException("Phone number already in use");

    if (newName != null && !newName.equals(""))
      customer.setName(newName);
    if (newEmail != null && !newEmail.equals(""))
      customer.setEmail(newEmail);
    if (newPhoneNumber != null && !newPhoneNumber.equals(""))
      customer.setPhoneNumber(newPhoneNumber);

    customerRepository.save(customer);
  }

  @Transactional(rollbackFor = Exception.class)
  @Modifying
  @Override
  public void deleteAccount(String phoneNumber) {
    Customer customer = findCustomerByPhoneNumber(phoneNumber);
    accountRepository.deleteByCustomerId(customer.getId());
    customerRepository.deleteById(customer.getId());
  }
}
