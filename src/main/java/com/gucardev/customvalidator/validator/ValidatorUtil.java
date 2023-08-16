package com.gucardev.customvalidator.validator;

import jakarta.validation.*;
import java.util.Objects;
import org.springframework.stereotype.Component;

@Component
public class ValidatorUtil<T> {

  ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
  Validator validator = factory.getValidator();

  public void validate(T object,ConstraintValidator clazz, String err) {
    if (!clazz.isValid(object, null)) {
      throw new RuntimeException(err);
    }
  }

  public void validate(T object) {
    for (ConstraintViolation<T> violation : validator.validate(object))
      processViolations(violation);
  }

  public void validate(T object, Class clazz) {
    for (ConstraintViolation<T> violation : validator.validate(object, clazz))
      processViolations(violation);
  }

  private void processViolations(ConstraintViolation<T> violation) {
    var annotationAttributes = violation.getConstraintDescriptor().getAttributes();
    int value =
        !Objects.isNull(annotationAttributes.get("value"))
            ? (int) annotationAttributes.get("value")
            : 0;
    throw new RuntimeException(violation.getMessage());
  }
}
