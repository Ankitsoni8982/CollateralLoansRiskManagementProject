package com.demo.project.pojo;

import org.junit.Test;
import org.meanbean.test.BeanTester;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.project.pojo.ReturnToRisk;

/**
 * Test - ReturnToRisk class
 */
@SpringBootTest
public class ReturnToRiskTest {

	@Test
	public void testPojoReturnToRisk() {
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(ReturnToRisk.class);
	}
}
