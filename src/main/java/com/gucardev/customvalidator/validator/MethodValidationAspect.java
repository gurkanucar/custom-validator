package com.gucardev.customvalidator.validator;

import jakarta.validation.*;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class MethodValidationAspect {

  private final Validator validator;

  public MethodValidationAspect(Validator validator) {
    this.validator = validator;
  }

  @Around("@annotation(methodValid)")
  public Object validateMethod(ProceedingJoinPoint joinPoint, MethodValid methodValid)
      throws Throwable {
    Object[] args = joinPoint.getArgs();
    for (Object arg : args) {
      Set<ConstraintViolation<Object>> violations = validator.validate(arg);
      if (!violations.isEmpty()) {

        violations.forEach(x -> log.error("error: {}", x.getMessage()));

        String customMessage = methodValid.message();
        ConstraintViolation<Object> violation = violations.iterator().next();
        throw new ValidationException(customMessage);
      }
    }
    return joinPoint.proceed();
  }
}
