package com.correia.cards.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import com.correia.cards.audit.*;

@Configuration
public class AuditorAwareConfig {

  @Bean
  public AuditorAware<String> auditorAwareProvider() {
    return new AuditorAwareImpl();
  }

}
