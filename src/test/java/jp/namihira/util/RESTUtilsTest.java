/**
 * Copyright 2013 Kosuke Namihira All Rights Reserved.
 */

package jp.namihira.util;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 * {@link RESTUtils}のテストクラス
 * @author Namihira
 *
 */
public class RESTUtilsTest
{


    /**
     * 正しく変換される。
     */
    @Test
    public void testReplaceURL(){
        //prepare
        String[] url = new String[] {"http://yahoo.co.jp/orgs/", "{id}", "/members/", "{id}"};
        final String ID = "1";
        final String ID_2 = "2";


        //action
        String result = RESTUtils.replaceURL(url[0] + url[1] + url[2] + url[3], ID, ID_2);

        //check
        assertEquals(url[0] + ID + url[2] + ID_2, result);
    }


}
