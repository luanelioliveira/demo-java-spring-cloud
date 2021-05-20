package com.luanelioliveira.hrauth.clients;

import com.luanelioliveira.hrauth.models.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "hr-users", path = "/users")
public interface UserClient {

  @GetMapping("/search")
  ResponseEntity<User> search(@RequestParam String email);
}
