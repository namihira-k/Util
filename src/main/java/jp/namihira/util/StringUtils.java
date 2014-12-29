/**
 * Copyright 2014 Kosuke Namihira All Rights Reserved.
 */

package jp.namihira.util;

import java.util.Objects;

/**
 * Stringユーティリティクラス
 */
public class StringUtils{

    /**
     * 指定された2つの文字列の長さの合計を返します
     *
     * @param s1　文字列
     * @param s2　文字列
     * @return　指定された2つの文字列の長さの合計
     *
     * @throws NullPointerException 引数がnullの場合
     */
    public static long sumLength(final String s1, final String s2){
        Objects.requireNonNull(s1);
        Objects.requireNonNull(s2);
        return s1.length() + s2.length();
    }

}
