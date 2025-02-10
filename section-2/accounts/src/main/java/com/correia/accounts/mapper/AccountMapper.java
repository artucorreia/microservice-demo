package com.correia.accounts.mapper;

import com.correia.accounts.dto.response.AccountDTO;
import com.correia.accounts.model.Account;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {

  Account toEntity(AccountDTO accountDTO);

  AccountDTO toDTO(Account account);

}
