package com.correia.accounts.infra.gateways.mapper;

import org.mapstruct.Mapper;

import com.correia.accounts.domain.entity.Customer;
import com.correia.accounts.infra.persistence.CustomerEntity;

@Mapper(componentModel = "spring")
public interface CustomerMapperGateway {

    CustomerEntity toEntity(Customer customer);

    Customer toDomain(CustomerEntity customerEntity);

}
