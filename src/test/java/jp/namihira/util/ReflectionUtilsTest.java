package jp.namihira.util;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * {@link ReflectionUtils}のテストクラス
 * Copyright 2013 Kosuke NAMIHIRA All Rights Reserved.
 *
 * @author kohsuke NAMIHIRA
 *
 */
public class ReflectionUtilsTest
{
	/**
	 * getType()のテスト
	 */
	@Test
	public void testGetTypeWrapperInt() {
		//prepare
		//nothing

        //action
		Class<?> clazz = null;
		try {
			clazz = ReflectionUtils.getType("int");
		} catch (ClassNotFoundException e) {
			assertTrue("test failed", false);
		}

		//check
		assertEquals(int.class, clazz);
	}

	/**
	 * getType()のテスト
	 */
	@Test
	public void testGetTypeWrapperInteger() {
		//prepare
		//nothing

		//action
		Class<?> clazz = null;
		try {
			clazz = ReflectionUtils.getType("java.lang.Integer");
		} catch (ClassNotFoundException e) {
			assertTrue("test failed", false);
		}

		//check
		assertEquals(Integer.class, clazz);
	}


}
