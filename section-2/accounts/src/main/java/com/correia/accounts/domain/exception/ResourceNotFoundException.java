package com.correia.accounts.domain.exception;

public class ResourceNotFoundException extends RuntimeException {
  public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue) {
    super(String.format("%s not found whit the given input data %s: '%s'", resourceName, fieldName, fieldValue));
  }
}
