package com.gucardev.customvalidator.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LengthValidatorImpl.class)
public @interface LengthValidator {
  String message() default "{CustomValidator1.message}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  int length();

  int errorCode() default 1000;
}
