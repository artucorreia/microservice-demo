package com.correia.accounts.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.correia.accounts.application.gateways.AccountGateway;
import com.correia.accounts.application.interactors.CreateAccountInteractor;
import com.correia.accounts.application.interactors.DeleteAccountInteractor;
import com.correia.accounts.application.interactors.FindAccountByCustomerIdInteractor;
import com.correia.accounts.application.interactors.FindCustomerByPhoneNumberInteractor;
import com.correia.accounts.application.interactors.UpdateAccountInteractor;
import com.correia.accounts.infra.gateways.AccountJpaRepositoryGateway;
import com.correia.accounts.infra.gateways.mapper.AccountMapperGateway;
import com.correia.accounts.infra.gateways.mapper.CustomerMapperGateway;
import com.correia.accounts.infra.persistence.AccountRepository;
import com.correia.accounts.infra.persistence.CustomerRepository;

@Configuration
public class AccountConfig {
    @Bean
    public AccountGateway accountGateway(AccountRepository accountRepository, CustomerRepository customerRepository,
            CustomerMapperGateway customerMapperGateway, AccountMapperGateway accountMapperGateway) {
        return new AccountJpaRepositoryGateway(accountRepository, customerRepository, customerMapperGateway,
                accountMapperGateway);
    }

    @Bean
    public FindAccountByCustomerIdInteractor findAccountByCustomerIdInteractor(AccountGateway accountGateway) {
        return new FindAccountByCustomerIdInteractor(accountGateway);
    }

    @Bean
    public FindCustomerByPhoneNumberInteractor findCustomerByPhoneNumberInteractor(AccountGateway accountGateway) {
        return new FindCustomerByPhoneNumberInteractor(accountGateway);
    }

    @Bean
    public CreateAccountInteractor createAccountInteractor(AccountGateway accountGateway) {
        return new CreateAccountInteractor(accountGateway);
    }

    @Bean
    public UpdateAccountInteractor updateAccountInteractor(AccountGateway accountGateway) {
        return new UpdateAccountInteractor(accountGateway);
    }

    @Bean
    public DeleteAccountInteractor deleteAccountInteractor(
            FindCustomerByPhoneNumberInteractor findCustomerByPhoneNumberInteractor, AccountGateway accountGateway) {
        return new DeleteAccountInteractor(findCustomerByPhoneNumberInteractor, accountGateway);
    }
}
