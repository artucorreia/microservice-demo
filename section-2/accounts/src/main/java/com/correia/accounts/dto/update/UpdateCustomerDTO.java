package com.correia.accounts.dto.update;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class UpdateCustomerDTO {

  @Size(max = 100)
  private String name;

  @Email
  private String email;

  @Size(max = 20)
  private String phoneNumber;

  public UpdateCustomerDTO() {
  }

  public UpdateCustomerDTO(@Size(max = 100) String name, @Email String email, @Size(max = 20) String phoneNumber) {
    this.name = name;
    this.email = email;
    this.phoneNumber = phoneNumber;
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
