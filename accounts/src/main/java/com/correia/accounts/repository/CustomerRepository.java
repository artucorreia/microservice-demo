package com.correia.accounts.repository;

import java.util.Optional;

import com.correia.accounts.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
  Optional<Customer> findByPhoneNumber(String phoneNumber);
}
