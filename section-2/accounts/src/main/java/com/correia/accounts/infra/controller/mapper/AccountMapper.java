package com.correia.accounts.infra.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

import com.correia.accounts.domain.entity.Account;
import com.correia.accounts.infra.controller.dto.response.AccountDTO;

@Mapper(componentModel = ComponentModel.SPRING)
public interface AccountMapper {

    AccountDTO toDTO(Account account);

}
