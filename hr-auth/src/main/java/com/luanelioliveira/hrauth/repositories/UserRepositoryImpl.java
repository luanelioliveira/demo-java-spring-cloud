package com.luanelioliveira.hrauth.repositories;

import com.luanelioliveira.hrauth.clients.UserClient;
import com.luanelioliveira.hrauth.models.User;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@RequiredArgsConstructor
@Repository
public class UserRepositoryImpl implements UserRepository {

  private final UserClient client;

  public Optional<User> findByEmail(String email) {
    try {
      return Optional.ofNullable(client.search(email).getBody());
    } catch (Exception e) {
      log.error(e.getMessage());

      return Optional.empty();
    }
  }
}
