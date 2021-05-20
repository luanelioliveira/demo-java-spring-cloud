package com.luanelioliveira.hrworker;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@RefreshScope
@Configuration
public class ServerConfig {

  @Getter
  @Value("${test.config}")
  private String config;
}
