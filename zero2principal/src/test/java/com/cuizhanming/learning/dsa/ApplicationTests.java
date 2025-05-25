package com.cuizhanming.learning.dsa;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void applicationStarts() {
		// This test checks if the application starts successfully.
		Application.main(new String[] {});
		assertTrue(true, "Application started successfully");
	}

}
