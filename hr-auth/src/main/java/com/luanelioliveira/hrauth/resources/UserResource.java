package com.luanelioliveira.hrauth.resources;

import com.luanelioliveira.hrauth.models.User;
import com.luanelioliveira.hrauth.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class UserResource {

  private final UserService service;

  @GetMapping("/users/search")
  public ResponseEntity<User> findUserByEmail(@RequestParam String email) {
    try {
      var user = service.findByEmail(email);
      return ResponseEntity.ok(user);
    } catch (Exception e) {
      return ResponseEntity.notFound().build();
    }
  }
}
