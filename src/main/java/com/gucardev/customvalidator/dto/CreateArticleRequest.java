package com.gucardev.customvalidator.dto;

import com.gucardev.customvalidator.validator.CustomValidator1;
import com.gucardev.customvalidator.validator.UserValidator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateArticleRequest {

  @CustomValidator1 private String title;
  private String content;
  @UserValidator private Long userId;
}
