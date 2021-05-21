package com.luanelioliveira.hrgatewayserver.configs;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@RequiredArgsConstructor
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

  private static final String[] PUBLIC = {
    "/hr-auth/oauth/token",
    "/hr-users/actuator/health",
    "/hr-auth/actuator/health",
    "/hr-worker/actuator/health",
    "/hr-payroll/actuator/health",
    "/hr-users/actuator/metrics",
    "/hr-auth/actuator/metrics",
    "/hr-worker/actuator/metrics",
    "/hr-payroll/actuator/metrics"
  };

  private static final String[] OPERATOR = {"/hr-worker/**"};

  private static final String[] ADMIN = {
    "/hr-payroll/**",
    "/hr-users/**",
    "/actuator/refresh",
    "/hr-worker/actuator/refresh",
    "/hr-auth/actuator/refresh"
  };

  private final JwtTokenStore tokenStore;

  @Override
  public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
    resources.tokenStore(tokenStore);
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers(PUBLIC)
        .permitAll()
        .antMatchers(HttpMethod.GET, OPERATOR)
        .hasAnyRole("OPERATOR", "ADMIN")
        .antMatchers(ADMIN)
        .hasRole("ADMIN")
        .anyRequest()
        .authenticated()
        .and()
        .cors()
        .configurationSource(corsConfigurationSource());
  }

  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
    var config = new CorsConfiguration();
    config.setAllowedOrigins(List.of("*"));
    config.setAllowedMethods(List.of("GET", "POST", "PUT", "PATCH", "DELETE"));
    config.setAllowCredentials(true);
    config.setAllowedHeaders(List.of("Authorization", "Content-Type"));

    var source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", config);

    return source;
  }

  @Bean
  public FilterRegistrationBean<CorsFilter> corsFilter() {
    var filter = new FilterRegistrationBean<>(new CorsFilter(corsConfigurationSource()));
    filter.setOrder(Ordered.HIGHEST_PRECEDENCE);

    return filter;
  }
}
