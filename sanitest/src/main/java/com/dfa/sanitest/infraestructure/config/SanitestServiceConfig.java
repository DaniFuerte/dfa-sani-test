package com.dfa.sanitest.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dfa.sanitest.application.repository.OperacionRepository;
import com.dfa.sanitest.application.service.OperacionService;

@Configuration
public class SanitestServiceConfig {

    @Bean
    public OperacionService operacionService (OperacionRepository operacionRepository) {
        return new OperacionService (operacionRepository);
    }

}
