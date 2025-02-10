package com.correia.loans.mapper;

import org.mapstruct.Mapper;
import com.correia.loans.model.Loan;
import com.correia.loans.dto.response.LoanDTO;

@Mapper(componentModel = "spring")
public interface LoanMapper {

  LoanDTO toDTO(Loan loan);

  Loan toEntity(LoanDTO loanDTO);

}
