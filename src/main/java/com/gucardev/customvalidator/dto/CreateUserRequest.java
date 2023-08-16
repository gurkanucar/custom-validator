package com.gucardev.customvalidator.dto;

import com.gucardev.customvalidator.validator.CustomValidator1;
import com.gucardev.customvalidator.validator.LengthValidator;
import com.gucardev.customvalidator.validator.ValidatorGroup1;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequest {
  @LengthValidator(
      length = 8,
      errorCode = 1234,
      message = "length validation error",
      groups = {ValidatorGroup1.class})
  private String name;

  @CustomValidator1 private String username;
}
