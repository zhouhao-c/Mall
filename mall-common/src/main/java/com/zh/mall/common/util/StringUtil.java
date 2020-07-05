package com.zh.mall.common.util;

public class StringUtil {
    public static boolean isEmpty( String s ) {
        return s == null || "".equals(s.trim());
    }
}
