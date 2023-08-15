package com.gucardev.customvalidator.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Article extends BaseEntity {

  private String title;

  @Column(length = 2000)
  private String content;

  @JsonBackReference
  @ManyToOne(fetch = FetchType.LAZY)
  private User user;
}
