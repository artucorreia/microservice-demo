package com.correia.accounts.application.gateways;

import java.util.Optional;

import com.correia.accounts.domain.entity.Account;
import com.correia.accounts.domain.entity.Customer;

public interface AccountGateway {

    Optional<Account> findAccountbyCustomerId(Long customerId);

    Optional<Customer> findCustomerByPhoneNumber(String phoneNumber);

    Customer createCustomer(Customer customer);

    void createAccount(Account account);

    void update(Customer customer);

    void delete(Long id);

}
