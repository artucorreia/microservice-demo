package com.correia.loans.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

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
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
      HttpStatusCode status, WebRequest request) {

    Map<String, String> fields = new HashMap<>();
    ex.getFieldErrors().forEach(fieldError -> {
      fields.put(fieldError.getField(), fieldError.getDefaultMessage());
    });

    ExceptionResponse response = new ArgumentNotValidExceptionResponse.Builder()
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .title("Argument not valid")
        .path(request.getDescription(false))
        .timestamp(LocalDateTime.now())
        .fields(fields)
        .build();

    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception exception, WebRequest request) {
    ExceptionResponse response = new ExceptionResponse.Builder()
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .title(exception.getMessage())
        .path(request.getDescription(false))
        .timestamp(LocalDateTime.now()).build();
    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(ResourceNotFoundException.class)
  public final ResponseEntity<ExceptionResponse> handleResourceNotFoundExceptions(Exception exception,
      WebRequest request) {
    ExceptionResponse response = new ExceptionResponse.Builder()
        .status(HttpStatus.NOT_FOUND)
        .title(exception.getMessage())
        .path(request.getDescription(false))
        .timestamp(LocalDateTime.now()).build();
    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
  }

}
