package com.demo.project.pojo;

import org.junit.Test;
import org.meanbean.test.BeanTester;

import com.demo.project.pojo.CollateralRiskPercent;

/**
 * Test - CollateralRiskPercent class
 */
public class CollateralRiskPercentTest {

	@Test
	public void testPojoCollateralRiskPercent() {
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(CollateralRiskPercent.class);
	}

}
