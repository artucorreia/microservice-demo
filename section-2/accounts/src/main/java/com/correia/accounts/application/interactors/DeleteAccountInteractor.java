package com.correia.accounts.application.interactors;

import com.correia.accounts.application.gateways.AccountGateway;
import com.correia.accounts.application.usecases.DeleteAccountUseCase;
import com.correia.accounts.application.usecases.FindCustomerByPhoneNumberUseCase;
import com.correia.accounts.domain.entity.Customer;

public class DeleteAccountInteractor implements DeleteAccountUseCase {

    private final FindCustomerByPhoneNumberUseCase findCustomerByPhoneNumberUseCase;
    private final AccountGateway accountGateway;

    public DeleteAccountInteractor(FindCustomerByPhoneNumberUseCase findCustomerByPhoneNumberUseCase,
            AccountGateway accountGateway) {
        this.findCustomerByPhoneNumberUseCase = findCustomerByPhoneNumberUseCase;
        this.accountGateway = accountGateway;
    }

    @Override
    public void delete(String phoneNumber) {
        Customer customer = findCustomerByPhoneNumberUseCase.find(phoneNumber);
        accountGateway.delete(customer.getId());
    }
}
