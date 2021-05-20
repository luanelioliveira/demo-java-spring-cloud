package com.luanelioliveira.hrusers.resources;

import com.luanelioliveira.hrusers.models.User;
import com.luanelioliveira.hrusers.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserResource {

  private final UserRepository repository;

  @GetMapping("/{id}")
  public ResponseEntity<User> getById(@PathVariable Long id) {
    var user = repository.findById(id);
    if (user.isPresent()) {
      return ResponseEntity.ok(user.get());
    }

    return ResponseEntity.notFound().build();
  }

  @GetMapping("/search")
  public ResponseEntity<User> search(@RequestParam String email) {

    var user = repository.findByEmail(email);
    if (user.isPresent()) {
      return ResponseEntity.ok(user.get());
    }

    return ResponseEntity.notFound().build();
  }
}
