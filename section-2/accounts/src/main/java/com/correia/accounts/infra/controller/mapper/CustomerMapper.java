package com.correia.accounts.infra.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

import com.correia.accounts.domain.entity.Customer;
import com.correia.accounts.infra.controller.dto.request.CreateCustomerDTO;
import com.correia.accounts.infra.controller.dto.response.CustomerDetailsDTO;

@Mapper(componentModel = ComponentModel.SPRING)
public interface CustomerMapper {

    @Mapping(target = "accountDTO", ignore = true)
    CustomerDetailsDTO toDetailsDTO(Customer customer);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    Customer toDomain(CreateCustomerDTO createCustomerDTO);

}
