package com.gucardev.customvalidator.dto;

import com.gucardev.customvalidator.validator.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateArticleRequest {

  @GenericValidator(value = {EmailValidator.class, PhoneNumberValidator.class})
  private String title;

  @CustomValidator1(customValue = 123)
  private String content;
  private Long userId;
}
