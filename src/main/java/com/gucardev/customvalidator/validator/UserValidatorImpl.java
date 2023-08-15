package com.gucardev.customvalidator.validator;

import com.gucardev.customvalidator.model.User;
import com.gucardev.customvalidator.service.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Optional;

public class UserValidatorImpl implements ConstraintValidator<UserValidator, Long> {

  private final UserService userService;

  public UserValidatorImpl(UserService userService) {
    this.userService = userService;
  }

  @Override
  public void initialize(UserValidator constraintAnnotation) {}

  @Override
  public boolean isValid(Long userId, ConstraintValidatorContext context) {
    if (userId == null) {
      return false;
    }
    Optional<User> userOptional = userService.getUserById(userId);
    return userOptional.isPresent();
  }
}
