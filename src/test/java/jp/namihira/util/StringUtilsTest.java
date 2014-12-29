/**
 * Copyright 2014 Kosuke Namihira All Rights Reserved.
 */

package jp.namihira.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilsTest {

    @Test
    public void testSumLength(){
        // prepare
        final String s1 = "a";
        final String s2 = "test";

        // action
        final long result = StringUtils.sumLength(s1, s2);

        // check
        assertEquals(s1.length() + s2.length(), result);
    }

    @Test(expected = NullPointerException.class)
    public void testSumLength_null(){
        // prepare
        // - nothing

        // action
        StringUtils.sumLength(null, null);

        // check
        // - throw Exception
    }
}
