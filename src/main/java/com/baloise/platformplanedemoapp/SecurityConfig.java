package com.baloise.platformplanedemoapp;

import com.azure.spring.cloud.autoconfigure.implementation.aad.security.AadWebApplicationHttpSecurityConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.apply(AadWebApplicationHttpSecurityConfigurer.aadWebApplication())
            .and()
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/demo").authenticated()
                    .anyRequest().permitAll()
            );
    return http.build();
  }

  @Bean
  @RequestScope
  public ServletUriComponentsBuilder urlBuilder() {
    return ServletUriComponentsBuilder.fromCurrentRequest();
  }
}
