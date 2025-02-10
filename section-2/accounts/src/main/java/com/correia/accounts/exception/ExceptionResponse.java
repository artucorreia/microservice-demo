package com.correia.accounts.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ExceptionResponse {
  private HttpStatus status;
  private String title;
  private String path;
  private LocalDateTime timestamp;

  public ExceptionResponse(HttpStatus status, String title, String path,
      LocalDateTime timestamp) {
    this.status = status;
    this.title = title;
    this.path = path;
    this.timestamp = timestamp;
  }

  public HttpStatus getStatus() {
    return status;
  }

  public String getTitle() {
    return title;
  }

  public String getPath() {
    return path;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public static class Builder {
    private HttpStatus status;
    private String title;
    private String path;
    private LocalDateTime timestamp;

    public Builder status(HttpStatus status) {
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

    public ExceptionResponse build() {
      return new ExceptionResponse(status, title, path, timestamp);
    }

  }

}
