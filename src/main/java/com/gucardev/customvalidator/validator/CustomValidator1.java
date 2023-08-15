package com.gucardev.customvalidator.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CustomValidator1Impl.class)
public @interface CustomValidator1 {
  String message() default "CustomValidator1 validation failed";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
