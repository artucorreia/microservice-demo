package com.correia.accounts.infra.controller.handle;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.correia.accounts.domain.exception.ArgumentNotValidExceptionResponse;
import com.correia.accounts.domain.exception.CustomerAlreadyExistsException;
import com.correia.accounts.domain.exception.ExceptionResponse;
import com.correia.accounts.domain.exception.ResourceNotFoundException;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @SuppressWarnings("null")
  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
      MethodArgumentNotValidException ex,
      HttpHeaders headers,
      HttpStatusCode status,
      WebRequest request) {
    List<FieldError> errorList = ex.getBindingResult().getFieldErrors();

    Map<String, String> fields = new HashMap<>();
    errorList.forEach(error -> {
      fields.put(error.getField(), error.getDefaultMessage());
    });

    ExceptionResponse response = new ArgumentNotValidExceptionResponse.Builder()
        .title("Validation error")
        .path(request.getDescription(false))
        .status(HttpStatus.BAD_REQUEST.value())
        .timestamp(LocalDateTime.now())
        .fields(fields)
        .build();

    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<ExceptionResponse> handleAllExceptions(
      Exception exception,
      WebRequest request) {
    ExceptionResponse response = new ExceptionResponse.Builder()
        .title(exception.getMessage())
        .path(request.getDescription(false))
        .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
        .timestamp(LocalDateTime.now())
        .build();
    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(ResourceNotFoundException.class)
  public final ResponseEntity<ExceptionResponse> handleResourceNotFoundExceptions(
      Exception exception,
      WebRequest request) {
    ExceptionResponse response = new ExceptionResponse.Builder()
        .title(exception.getMessage())
        .path(request.getDescription(false))
        .status(HttpStatus.NOT_FOUND.value())
        .timestamp(LocalDateTime.now())
        .build();
    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(CustomerAlreadyExistsException.class)
  public final ResponseEntity<ExceptionResponse> handleCustomerAlreadyExistsExceptions(
      Exception exception,
      WebRequest request) {
    ExceptionResponse response = new ExceptionResponse.Builder()
        .title(exception.getMessage())
        .path(request.getDescription(false))
        .status(HttpStatus.BAD_REQUEST.value())
        .timestamp(LocalDateTime.now())
        .build();
    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }
}
