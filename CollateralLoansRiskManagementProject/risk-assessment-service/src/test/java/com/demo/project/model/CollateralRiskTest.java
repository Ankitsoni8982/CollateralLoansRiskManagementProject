package com.demo.project.model;

import org.junit.Test;
import org.meanbean.test.BeanTester;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.project.model.CollateralRisk;

/**
 * CollateralRiskTest
 */
@SpringBootTest
public class CollateralRiskTest {

	@Test
	public void testModelCollateralRisk() {
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(CollateralRisk.class);
	}

}