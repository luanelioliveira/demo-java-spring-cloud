package com.luanelioliveira.hrworker.resources;

import com.luanelioliveira.hrworker.ServerConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/configs")
public class ConfigResource {

  private final ServerConfig serverConfig;

  @GetMapping
  private String getConfigs() {
    return serverConfig.getConfig();
  }
}
