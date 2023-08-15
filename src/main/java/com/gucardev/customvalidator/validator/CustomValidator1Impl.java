package com.gucardev.customvalidator.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CustomValidator1Impl implements ConstraintValidator<CustomValidator1, String> {

  @Override
  public void initialize(CustomValidator1 constraintAnnotation) {}

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return false;
  }
}
