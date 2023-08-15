package com.gucardev.customvalidator.dto;

import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
  private Long id;
  private Date createdDate;
  private Date lastModifiedDate;
  private String name;
  private String username;
  private List<ArticleDto> articles;
}
