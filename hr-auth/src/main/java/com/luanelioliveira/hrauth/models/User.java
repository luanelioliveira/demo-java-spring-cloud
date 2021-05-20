package com.luanelioliveira.hrauth.models;

import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class User {

  private Long id;
  private String name;
  private String email;
  private String password;
  private Set<Role> roles = new HashSet<>();
}
