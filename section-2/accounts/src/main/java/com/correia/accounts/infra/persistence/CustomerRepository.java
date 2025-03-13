package com.correia.accounts.infra.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
  Optional<CustomerEntity> findByPhoneNumber(String phoneNumber);
}
