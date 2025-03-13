package com.correia.accounts.application.usecases;

import com.correia.accounts.domain.entity.Account;

public interface FindAccountByCustomerIdUseCase {
    Account find(Long customerId);
}
