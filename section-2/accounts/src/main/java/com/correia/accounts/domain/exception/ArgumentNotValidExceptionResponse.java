package com.correia.accounts.domain.exception;

import java.time.LocalDateTime;
import java.util.Map;

public class ArgumentNotValidExceptionResponse extends ExceptionResponse {

  private Map<String, String> fields;

  public ArgumentNotValidExceptionResponse(Integer status, String title, String path,
      LocalDateTime timestamp, Map<String, String> fields) {
    super(status, title, path, timestamp);
    this.fields = fields;
  }

  public Map<String, String> getFields() {
    return fields;
  }

  public static class Builder {

    private Integer status;
    private String title;
    private String path;
    private LocalDateTime timestamp;
    private Map<String, String> fields;

    public Builder status(Integer status) {
      this.status = status;
      return this;
    }

    public Builder title(String title) {
      this.title = title;
      return this;
    }

    public Builder path(String path) {
      this.path = path;
      return this;
    }

    public Builder timestamp(LocalDateTime timestamp) {
      this.timestamp = timestamp;
      return this;
    }

    public Builder fields(Map<String, String> fields) {
      this.fields = fields;
      return this;
    }

    public ArgumentNotValidExceptionResponse build() {
      return new ArgumentNotValidExceptionResponse(status, title, path, timestamp, fields);
    }

  }
}
