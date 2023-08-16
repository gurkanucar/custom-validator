package com.gucardev.customvalidator.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class LengthValidatorImpl implements ConstraintValidator<LengthValidator, String> {
  private int length;

  @Override
  public void initialize(LengthValidator constraintAnnotation) {
    this.length = constraintAnnotation.length();
  }
  public LengthValidatorImpl() {
  }
  public LengthValidatorImpl(int length) {
    this.length = length;
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (value == null) {
      return false;
    }
    return value.length() == length;
  }
}
