package com.correia.accounts.application.interactors;

import java.util.Optional;

import com.correia.accounts.application.gateways.AccountGateway;
import com.correia.accounts.application.usecases.UpdateAccountUseCase;
import com.correia.accounts.domain.entity.Customer;
import com.correia.accounts.domain.exception.CustomerAlreadyExistsException;

public class UpdateAccountInteractor implements UpdateAccountUseCase {

    private final AccountGateway accountGateway;

    public UpdateAccountInteractor(AccountGateway accountGateway) {
        this.accountGateway = accountGateway;
    }

    @Override
    public void update(Customer customer, String newName, String newEmail, String newPhoneNumber) {
        Optional<Customer> optionalCustomer = accountGateway.findCustomerByPhoneNumber(newPhoneNumber);
        if (optionalCustomer.isPresent())
            throw new CustomerAlreadyExistsException("Phone number already in use");

        if (newName != null && !newName.equals(""))
            customer.setName(newName);
        if (newEmail != null && !newEmail.equals(""))
            customer.setEmail(newEmail);
        if (newPhoneNumber != null && !newPhoneNumber.equals(""))
            customer.setPhoneNumber(newPhoneNumber);

        accountGateway.update(customer);
    }

}
