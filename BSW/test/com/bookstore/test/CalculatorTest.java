package com.bookstore.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testAdd() {
		Calculator  calculator = new Calculator();
		int a=20;
		int b=40;
		int result=calculator.add(a, b);
		int excepted=60;
		assertEquals(excepted, result);
	}

}