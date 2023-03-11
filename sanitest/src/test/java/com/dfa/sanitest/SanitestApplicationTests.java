package com.dfa.sanitest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.dfa.sanitest.infraestructure.config.SanitestApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest(classes = SanitestApplication.class)
class SanitestApplicationTests {

	@Test
	void contextLoads() {
		log.info("Hello There!");
		assertTrue(true);
	}

}
