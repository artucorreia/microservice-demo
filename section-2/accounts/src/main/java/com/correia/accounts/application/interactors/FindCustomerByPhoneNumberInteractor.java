package com.correia.accounts.application.interactors;

import com.correia.accounts.application.gateways.AccountGateway;
import com.correia.accounts.application.usecases.FindCustomerByPhoneNumberUseCase;
import com.correia.accounts.domain.entity.Customer;
import com.correia.accounts.domain.exception.ResourceNotFoundException;

public class FindCustomerByPhoneNumberInteractor implements FindCustomerByPhoneNumberUseCase {

    private final AccountGateway accountGateway;

    public FindCustomerByPhoneNumberInteractor(AccountGateway accountGateway) {
        this.accountGateway = accountGateway;
    }

    @Override
    public Customer find(String phoneNumber) {
        return accountGateway.findCustomerByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "phone number", phoneNumber));
    }

}
