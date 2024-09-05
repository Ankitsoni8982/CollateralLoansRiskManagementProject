package com.demo.project.model;

import org.junit.Test;
import org.meanbean.test.BeanTester;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.project.model.CollateralMarketValue;

/**
 * Test - CollateralMarketValue class
 */
@SpringBootTest
public class CollateralMarketValueTest {

	@Test
	public void testModelCollateralMarketValue() {
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(CollateralMarketValue.class);
	}

}
