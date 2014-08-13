/**
 * Copyright 2014 Kosuke Namihira All Rights Reserved.
 */

package jp.namihira.util;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

/**
 * class for just test.
 */
public class SimpleTest {

	/**
	 * for test Arrays.sorts
	 */
	@Test
	public void testArraysSort(){
		//prepare
		String[] strs = new String[]{"a", "ccc", "bb"};

		//action
		Arrays.sort(strs, new LengthComparator());

		//check
		assertEquals("a", strs[0]);
		assertEquals("bb", strs[1]);
		assertEquals("ccc", strs[2]);
	}

	class LengthComparator implements Comparator<String> {
		public int compare(String first, String second) {
			return Integer.compare(first.length(), second.length());
		}
	}

}
