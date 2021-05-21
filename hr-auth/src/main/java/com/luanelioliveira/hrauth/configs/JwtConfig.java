package com.luanelioliveira.hrauth.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class JwtConfig {

  @Bean
  public JwtAccessTokenConverter accessTokenConverter() {
    var converter = new JwtAccessTokenConverter();
    converter.setSigningKey("MY-SECRET-KEY");
    return converter;
  }

  @Bean
  public JwtTokenStore tokenStore() {
    return new JwtTokenStore(accessTokenConverter());
  }
}
