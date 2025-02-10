package com.correia.loans.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ExceptionResponse {
  private HttpStatus status;
  private LocalDateTime timestamp;
  private String path;
  private String title;

  public ExceptionResponse(HttpStatus status, LocalDateTime timestamp, String path, String title) {
    this.status = status;
    this.timestamp = timestamp;
    this.path = path;
    this.title = title;
  }

  public HttpStatus getStatus() {
    return status;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public String getPath() {
    return path;
  }

  public String getTitle() {
    return title;
  }

  public static class Builder {
    private HttpStatus status;
    private LocalDateTime timestamp;
    private String path;
    private String title;

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

    public ExceptionResponse build() {
      return new ExceptionResponse(status, timestamp, path, title);
    }

  }
}
