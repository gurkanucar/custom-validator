package com.gucardev.customvalidator.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodValid {
    String message() default "Method validation failed";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
