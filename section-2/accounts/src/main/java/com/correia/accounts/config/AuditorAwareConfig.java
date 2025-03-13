package com.correia.accounts.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Component;

import com.correia.accounts.infra.persistence.AuditorAwareImpl;

@Component
@EnableJpaAuditing
public class AuditorAwareConfig {

  @Bean
  public AuditorAware<String> auditorProvider() {
    return new AuditorAwareImpl();
  }
}
