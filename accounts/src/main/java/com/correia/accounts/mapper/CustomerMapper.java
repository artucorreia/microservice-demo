package com.correia.accounts.mapper;

import com.correia.accounts.dto.CustomerDTO;
import com.correia.accounts.model.Customer;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface CustomerMapper {

  Customer toEntity(CustomerDTO customerDTO);

  CustomerDTO toDTO(Customer customer);

}
