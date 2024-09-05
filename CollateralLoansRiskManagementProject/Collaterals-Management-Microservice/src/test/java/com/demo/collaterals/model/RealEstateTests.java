package com.demo.collaterals.model;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.collaterals.model.RealEstate;

/**
 * Test - RealEstate class
 */
@SpringBootTest
class RealEstateTests {

	@Test
	void testRealEstateBean() {
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(RealEstate.class);
	}

}
