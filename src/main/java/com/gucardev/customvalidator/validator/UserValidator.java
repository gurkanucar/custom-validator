package com.gucardev.customvalidator.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserValidatorImpl.class)
public @interface UserValidator {
  String message() default "UserValidatorImpl validation failed";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
