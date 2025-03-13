package com.correia.accounts.domain.entity;

import java.time.LocalDateTime;

public class Customer extends Base {

    private Long id;
    private String name;
    private String email;
    private String phoneNumber;

    public Customer() {
    }

    public Customer(LocalDateTime createdAt, String createdBy, LocalDateTime updatedAt, String updatedBy, Long id,
            String name, String email, String phoneNumber) {
        super(createdAt, createdBy, updatedAt, updatedBy);
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}