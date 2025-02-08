package com.correia.accounts.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {

  @Column(name = "created_at", updatable = false)
  @CreationTimestamp
  private LocalDateTime createdAt;

  @Column(name = "created_by", updatable = false, length = 20)
  private String createdBy;

  @Column(name = "updated_at", insertable = false)
  @UpdateTimestamp
  private LocalDateTime updatedAt;

  @Column(name = "updated_by", insertable = false, length = 20)
  private String updatedBy;

  public BaseEntity() {
  }

  public BaseEntity(LocalDateTime createdAt, String createdBy, LocalDateTime updatedAt, String updatedBy) {
    this.createdAt = createdAt;
    this.createdBy = createdBy;
    this.updatedAt = updatedAt;
    this.updatedBy = updatedBy;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public String getUpdatedBy() {
    return updatedBy;
  }

  public void setUpdatedBy(String updatedBy) {
    this.updatedBy = updatedBy;
  }

  @Override
  public String toString() {
    return "BaseEntity{createdAt=" + createdAt + ", createdBy=" + createdBy + ", updatedAt=" + updatedAt
        + ", updatedBy="
        + updatedBy + ", getCreatedAt()=" + getCreatedAt() + ", getCreatedBy()=" + getCreatedBy() + ", getUpdatedAt()="
        + getUpdatedAt() + ", getUpdatedBy()=" + getUpdatedBy() + ", getClass()=" + getClass() + ", hashCode()="
        + hashCode() + ", toString()=" + super.toString() + "}";
  }
}
