package com.correia.accounts.application.usecases;

import com.correia.accounts.domain.entity.Customer;

public interface FindCustomerByPhoneNumberUseCase {
    Customer find(String phoneNumber);
}
