package com.luanelioliveira.hrauth.repositories;

import com.luanelioliveira.hrauth.models.User;
import java.util.Optional;

public interface UserRepository {

  Optional<User> findByEmail(String email);
}
