package com.gucardev.customvalidator.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class GenericValidatorImpl implements ConstraintValidator<GenericValidator, Object> {

  private Class<? extends ConstraintValidator<?, ?>>[] validatorClasses;

  @Override
  public void initialize(GenericValidator constraintAnnotation) {
    validatorClasses = constraintAnnotation.value();
  }

  @Override
  public boolean isValid(Object value, ConstraintValidatorContext context) {
    for (Class<? extends ConstraintValidator<?, ?>> validatorClass : validatorClasses) {
      ConstraintValidator<?, Object> validator = createValidatorInstance(validatorClass);
      if (!validator.isValid(value, context)) {
        return false;
      }
    }
    return true;
  }

  @SuppressWarnings("unchecked")
  private ConstraintValidator<?, Object> createValidatorInstance(
      Class<? extends ConstraintValidator<?, ?>> validatorClass) {
    try {
      return (ConstraintValidator<?, Object>) validatorClass.newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
      throw new IllegalArgumentException("Failed to create validator instance", e);
    }
  }
}
