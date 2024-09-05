package com.demo.training.exception;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.demo.training.exception.CollateralTypeNotFoundException;

/**
 * @Test CollateralTypeNotFoundException Class
 * @author POD-6
 */
public class CollateralTypeNotFoundExceptionTest {
	CollateralTypeNotFoundException colNotFound;

	@Before
	public void init() {
		colNotFound = new CollateralTypeNotFoundException("Loan Not Found Exception");
	}

	@Test
	public void testLoanNotFound() {
		assertEquals("Loan Not Found Exception", colNotFound.getMessage());
	}
}
