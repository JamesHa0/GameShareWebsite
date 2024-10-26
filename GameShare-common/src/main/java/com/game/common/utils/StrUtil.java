package com.game.common.utils;

public class StrUtil {
    public static boolean isBlankOrUndefined(String str)
    {
        return str == null || str.isEmpty() || str.trim().isEmpty();
    }

    public static boolean isNull(String str)
    {
    	return str == null || str.isEmpty() || str.trim().isEmpty();
    }

    public static boolean isNotNull(String str)
    {
    	return !isNull(str);
    }
}
