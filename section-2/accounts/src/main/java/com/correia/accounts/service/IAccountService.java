package com.correia.accounts.service;

import com.correia.accounts.model.Account;
import com.correia.accounts.model.Customer;

public interface IAccountService {
  Customer findCustomerByPhoneNumber(String phoneNumber);

  Account findAccountByCustomerId(Long customerId);

  void createAccount(Customer customer);

  void updateAccount(Customer customer, String newName, String newEmail, String newPhoneNumber);

  void deleteAccount(String phoneNumber);
}
