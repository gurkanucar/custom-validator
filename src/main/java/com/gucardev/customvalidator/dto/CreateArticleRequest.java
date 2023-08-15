package com.gucardev.customvalidator.dto;

import com.gucardev.customvalidator.validator.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateArticleRequest {

  @GenericValidator(value = {EmailValidator.class, PhoneNumberValidator.class})
  private String title;


  private String content;
  private Long userId;
}
