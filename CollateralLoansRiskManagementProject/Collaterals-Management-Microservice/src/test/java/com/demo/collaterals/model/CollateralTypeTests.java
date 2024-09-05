package com.demo.collaterals.model;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.collaterals.model.Collateral;

/**
 * Test - CollateralType class
 */
@SpringBootTest
class CollateralTypeTests
{

	@Test
	void testCollateralTypeBean() {
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(Collateral.class);
	}
}
