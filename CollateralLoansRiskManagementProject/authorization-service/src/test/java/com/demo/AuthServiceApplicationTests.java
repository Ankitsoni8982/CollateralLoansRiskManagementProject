package com.demo;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.AuthServiceApplication;

/**
 * Test - AuthServiceApplication
 */
@SpringBootTest
public class AuthServiceApplicationTests {

	@Test
	public void appplicationStarts() throws IOException {
		AuthServiceApplication.main(new String[] {});
		assertTrue(true);
	}
}
