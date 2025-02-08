package com.correia.accounts.service;

import com.correia.accounts.dto.CustomerDTO;

public interface IAccountService {

  void createAccount(CustomerDTO customerDTO);
}
