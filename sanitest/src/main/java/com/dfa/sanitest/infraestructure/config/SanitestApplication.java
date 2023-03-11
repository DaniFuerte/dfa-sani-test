package com.dfa.sanitest.infraestructure.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.dfa.sanitest.infraestructure")
@EntityScan(basePackages="com.dfa.sanitest.domain")
public class SanitestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SanitestApplication.class, args);
	}

}
