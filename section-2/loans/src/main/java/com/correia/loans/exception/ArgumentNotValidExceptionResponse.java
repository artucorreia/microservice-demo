package com.correia.loans.exception;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;

public class ArgumentNotValidExceptionResponse extends ExceptionResponse {
  private Map<String, String> fields;

  public ArgumentNotValidExceptionResponse(HttpStatus status, LocalDateTime timestamp, String path, String title,
      Map<String, String> fields) {
    super(status, timestamp, path, title);
    this.fields = fields;

  }

  public Map<String, String> getFields() {
    return fields;
  }

  public static class Builder {
    private HttpStatus status;
    private LocalDateTime timestamp;
    private String path;
    private String title;
    private Map<String, String> fields;

    public Builder status(HttpStatus status) {
      this.status = status;
      return this;
    }

    public Builder timestamp(LocalDateTime timestamp) {
      this.timestamp = timestamp;
      return this;
    }

    public Builder path(String path) {
      this.path = path;
      return this;
    }

    public Builder title(String title) {
      this.title = title;
      return this;
    }

    public Builder fields(Map<String, String> fields) {
      this.fields = fields;
      return this;
    }

    public ArgumentNotValidExceptionResponse build() {
      return new ArgumentNotValidExceptionResponse(status, timestamp, path, title, fields);
    }

  }
}
