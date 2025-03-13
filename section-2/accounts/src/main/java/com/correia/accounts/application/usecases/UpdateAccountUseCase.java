package com.correia.accounts.application.usecases;

import com.correia.accounts.domain.entity.Customer;

public interface UpdateAccountUseCase {
    void update(Customer customer, String newName, String newEmail, String newPhoneNumber);
}
