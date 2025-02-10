package com.correia.accounts.repository;

import java.util.Optional;

import com.correia.accounts.model.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
  Optional<Account> findByCustomerId(Long id);

  @Modifying
  void deleteByCustomerId(Long customerId);
}
