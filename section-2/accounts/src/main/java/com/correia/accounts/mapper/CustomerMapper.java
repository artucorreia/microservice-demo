package com.correia.accounts.mapper;

import com.correia.accounts.dto.create.CreateCustomerDTO;
import com.correia.accounts.dto.response.CustomerDetailsDTO;
import com.correia.accounts.model.Customer;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface CustomerMapper {

  Customer toEntity(CreateCustomerDTO customerDTO);

  CreateCustomerDTO toDTO(Customer customer);

  CustomerDetailsDTO toDetailsDTO(Customer customer);
}
