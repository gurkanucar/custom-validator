package com.gucardev.customvalidator.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<GenericValidator, Object> {
  @Override
  public void initialize(GenericValidator constraintAnnotation) {}

  @Override
  public boolean isValid(Object value, ConstraintValidatorContext context) {
    return false;
    //  return value != null && value.matches("\\d{10}");
  }
}
