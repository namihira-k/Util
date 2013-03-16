/**
 * Copyright 2013 Kosuke Namihira All Rights Reserved.
 */

package jp.namihira.util;

/**
 *
 * REST関係のユーティリティクラス
 * @author Namihira
 *
 */
public class RESTUtils
{

    private RESTUtils(){};


    /**
     * URLの"{XXX}"の部分にidsを値を置き換えます。
     * 例：/organizations/{id}/menbers/{id} -> /organizations/1/menbers/tom
     * @param url
     * @param ids
     */
    public static String replaceURL(final String url, String... ids) {
        final String regex = "[{][^}]+[}]";
        String tmp = url;

        for(String id : ids) {
            tmp = tmp.replaceFirst(regex, id);
        }

        return tmp;
    }

}
