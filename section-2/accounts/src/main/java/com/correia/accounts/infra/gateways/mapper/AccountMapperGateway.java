package com.correia.accounts.infra.gateways.mapper;

import com.correia.accounts.domain.entity.Account;
import com.correia.accounts.infra.persistence.AccountEntity;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapperGateway {

  AccountEntity toEntity(Account account);

  Account toDomain(AccountEntity accountEntity);
}
