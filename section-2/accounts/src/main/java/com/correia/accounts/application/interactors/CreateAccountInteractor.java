package com.correia.accounts.application.interactors;

import java.util.Optional;
import java.util.Random;

import com.correia.accounts.application.gateways.AccountGateway;
import com.correia.accounts.application.usecases.CreateAccountUseCase;
import com.correia.accounts.domain.entity.Account;
import com.correia.accounts.domain.entity.Customer;
import com.correia.accounts.domain.exception.CustomerAlreadyExistsException;
import com.correia.accounts.infra.controller.constant.AccountConstant;

public class CreateAccountInteractor implements CreateAccountUseCase {

    private final AccountGateway accountGateway;

    public CreateAccountInteractor(AccountGateway accountGateway) {
        this.accountGateway = accountGateway;
    }

    @Override
    public void create(Customer customer) {
        Optional<Customer> optionalCustomer = accountGateway.findCustomerByPhoneNumber(customer.getPhoneNumber());
        if (optionalCustomer.isPresent())
            throw new CustomerAlreadyExistsException("Phone number already in use");

        customer.setName(customer.getName().trim());
        customer.setPhoneNumber(customer.getPhoneNumber().trim());

        Customer savedCustomer = accountGateway.createCustomer(customer);
        accountGateway.createAccount(createNewAccount(savedCustomer));
    }

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
