package com.correia.accounts.application.interactors;

import com.correia.accounts.application.gateways.AccountGateway;
import com.correia.accounts.application.usecases.FindAccountByCustomerIdUseCase;
import com.correia.accounts.domain.entity.Account;
import com.correia.accounts.domain.exception.ResourceNotFoundException;

public class FindAccountByCustomerIdInteractor implements FindAccountByCustomerIdUseCase {

    private final AccountGateway accountGateway;

    public FindAccountByCustomerIdInteractor(AccountGateway accountGateway) {
        this.accountGateway = accountGateway;
    }

    @Override
    public Account find(Long customerId) {
        return accountGateway.findAccountbyCustomerId(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Account", "customer id", customerId.toString()));
    }

}
