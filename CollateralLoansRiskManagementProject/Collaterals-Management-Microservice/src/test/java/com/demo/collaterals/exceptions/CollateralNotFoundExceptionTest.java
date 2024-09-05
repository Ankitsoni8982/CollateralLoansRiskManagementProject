package com.demo.collaterals.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.collaterals.exceptions.CollateralNotFoundException;

/**
 * Test - CollateralNotFoundException class
 */
@SpringBootTest
class CollateralNotFoundExceptionTest {

	@Test
	void testCollateralNotFoundException() {
		CollateralNotFoundException collateralNotFoundException = new CollateralNotFoundException(
				"Collateral Not Found");
		assertEquals("Collateral Not Found", collateralNotFoundException.getMessage());
	}

}
