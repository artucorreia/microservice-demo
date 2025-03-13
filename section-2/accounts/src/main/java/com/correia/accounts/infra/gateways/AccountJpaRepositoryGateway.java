package com.correia.accounts.infra.gateways;

import java.util.Optional;

import com.correia.accounts.application.gateways.AccountGateway;
import com.correia.accounts.domain.entity.Account;
import com.correia.accounts.domain.entity.Customer;
import com.correia.accounts.infra.gateways.mapper.AccountMapperGateway;
import com.correia.accounts.infra.gateways.mapper.CustomerMapperGateway;
import com.correia.accounts.infra.persistence.AccountEntity;
import com.correia.accounts.infra.persistence.AccountRepository;
import com.correia.accounts.infra.persistence.CustomerEntity;
import com.correia.accounts.infra.persistence.CustomerRepository;

public class AccountJpaRepositoryGateway implements AccountGateway {

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;
    private final CustomerMapperGateway customerMapper;
    private final AccountMapperGateway accountMapper;

    public AccountJpaRepositoryGateway(AccountRepository accountRepository, CustomerRepository customerRepository,
            CustomerMapperGateway customerMapper, AccountMapperGateway accountMapper) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
        this.accountMapper = accountMapper;
    }

    @Override
    public Optional<Account> findAccountbyCustomerId(Long customerId) {
        Optional<AccountEntity> accountEntity = accountRepository.findByCustomerId(customerId);
        return accountEntity.map(entity -> accountMapper.toDomain(entity));
    }

    @Override
    public Optional<Customer> findCustomerByPhoneNumber(String phoneNumber) {
        Optional<CustomerEntity> customerEntity = customerRepository.findByPhoneNumber(phoneNumber);
        return customerEntity.map(entity -> customerMapper.toDomain(entity));
    }

    @Override
    public void createAccount(Account account) {
        AccountEntity accountEntity = accountMapper.toEntity(account);
        accountRepository.save(accountEntity);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        CustomerEntity customerEntity = customerMapper.toEntity(customer);
        return customerMapper.toDomain(customerRepository.save(customerEntity));
    }

    @Override
    public void update(Customer customer) {
        CustomerEntity customerEntity = customerMapper.toEntity(customer);
        customerRepository.save(customerEntity);
    }

    @Override
    public void delete(Long id) {
        accountRepository.deleteByCustomerId(id);
        customerRepository.deleteById(id);
    }

}
