package com.demo.collaterals.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.request.WebRequest;

import com.demo.collaterals.exceptions.CollateralAlreadyExistsException;
import com.demo.collaterals.exceptions.EntityExceptionHandler;

/**
 * Test - EntityExceptionHandler class
 */
@SpringBootTest
class EntityExceptionHandlerTest {

	@Test
	void testEntityException() {
		WebRequest web = null;
		CollateralAlreadyExistsException loan = new CollateralAlreadyExistsException("Collateral Exist");
		EntityExceptionHandler exp = new EntityExceptionHandler();
		assertEquals(500, exp.handleAnyException(loan, web).getStatusCodeValue());
	}

}