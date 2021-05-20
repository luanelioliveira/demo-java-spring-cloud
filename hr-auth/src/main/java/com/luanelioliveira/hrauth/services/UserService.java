package com.luanelioliveira.hrauth.services;

import com.luanelioliveira.hrauth.models.User;
import com.luanelioliveira.hrauth.repositories.UserRepository;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

  private final UserRepository repository;

  public User findByEmail(String email) {
    return repository.findByEmail(email).orElseThrow(NoSuchElementException::new);
  }
}
