package com.luanelioliveira.hrauth.services;

import com.luanelioliveira.hrauth.models.User;
import com.luanelioliveira.hrauth.repositories.UserRepository;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

  private final UserRepository repository;

  public User findByEmail(String email) {
    return repository.findByEmail(email).orElseThrow(NoSuchElementException::new);
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    try {
      var user = findByEmail(username);
      log.info(user.toString());

      return findByEmail(username);
    } catch (NoSuchElementException ex) {
      throw new UsernameNotFoundException("User not found");
    }
  }
}
