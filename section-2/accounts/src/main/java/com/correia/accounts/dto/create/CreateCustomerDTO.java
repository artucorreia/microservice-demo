package com.correia.accounts.dto.create;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateCustomerDTO {

  @NotBlank(message = "Name is mandatory")
  @Size(min = 5, max = 50, message = "The length of the customer name should be between 5 and 50")
  private String name;

  @NotBlank(message = "Email is mandatory")
  @Email(message = "Email must be valid")
  private String email;

  @NotBlank(message = "Phone number is mandatory")
  @Size(min = 10, max = 10, message = "Phone number must be 10 digits")
  private String phoneNumber;

  public CreateCustomerDTO() {
  }

  public CreateCustomerDTO(String name, String email, String phoneNumber) {
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
