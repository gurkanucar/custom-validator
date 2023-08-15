package com.gucardev.customvalidator.dto;

import jakarta.persistence.*;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleDto {
  private Long id;
  private Date createdDate;
  private Date lastModifiedDate;
  private String title;
  private String content;
  private UserDto user;
}
