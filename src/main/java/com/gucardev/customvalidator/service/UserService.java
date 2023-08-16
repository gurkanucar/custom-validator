package com.gucardev.customvalidator.service;

import com.gucardev.customvalidator.dto.CreateUserRequest;
import com.gucardev.customvalidator.model.User;
import com.gucardev.customvalidator.repository.UserRepository;
import com.gucardev.customvalidator.validator.ValidatorGroup1;
import com.gucardev.customvalidator.validator.ValidatorUtil;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;
  private final ValidatorUtil validator;

  public UserService(UserRepository userRepository, ValidatorUtil validator) {
    this.userRepository = userRepository;
    this.validator = validator;
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public Optional<User> getUserById(Long id) {
    return userRepository.findById(id);
  }

  public User createUser(CreateUserRequest request) {
    validator.validate(request, ValidatorGroup1.class);
    User user = new User();
    BeanUtils.copyProperties(request, user);
    return userRepository.save(user);
  }

  public User updateUser(Long id, User updatedUser) {
    Optional<User> optionalUser = userRepository.findById(id);
    if (optionalUser.isPresent()) {
      User user = optionalUser.get();
      BeanUtils.copyProperties(
          updatedUser, user, "id", "createdDate", "lastModifiedDate", "username");
      return userRepository.save(user);
    } else {
      throw new IllegalArgumentException("User not found with id: " + id);
    }
  }

  public void deleteUser(Long id) {
    userRepository.deleteById(id);
  }
}
