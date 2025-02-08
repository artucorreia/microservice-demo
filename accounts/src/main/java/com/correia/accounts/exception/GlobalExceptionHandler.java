package com.correia.accounts.exception;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
      MethodArgumentNotValidException ex,
      HttpHeaders headers,
      HttpStatusCode status,
      WebRequest request) {
    List<String> errorMessages = ex.getBindingResult()
        .getFieldErrors()
        .stream()
        .map(error -> error.getField() + ": " + error.getDefaultMessage())
        .toList();

    ExceptionResponse response = new ExceptionResponse.Builder()
        .title(String.join(", ", errorMessages))
        .path(request.getDescription(false))
        .status(HttpStatus.BAD_REQUEST)
        .timestamp(LocalDateTime.now())
        .build();

    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }

  /*
   * General Exceptions
   */

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<ExceptionResponse> handleAllExceptions(
      Exception exception,
      WebRequest request) {
    ExceptionResponse response = new ExceptionResponse.Builder()
        .title(exception.getMessage())
        .path(request.getDescription(false))
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .timestamp(LocalDateTime.now())
        .build();
    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(CustomerAlreadyExistsException.class)
  public final ResponseEntity<ExceptionResponse> handleCustomerAlreadyExistsExceptions(
      CustomerAlreadyExistsException exception,
      WebRequest request) {
    ExceptionResponse response = new ExceptionResponse.Builder()
        .title(exception.getMessage())
        .path(request.getDescription(false))
        .status(HttpStatus.BAD_REQUEST)
        .timestamp(LocalDateTime.now())
        .build();
    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }
}
