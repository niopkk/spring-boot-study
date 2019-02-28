package com.bbz.util;

import org.apache.commons.lang3.StringUtils;

public abstract class Strings extends StringUtils {
    
    /**
     * 类型转换 string转int
     *
     * @param value 原始值
     * @return int
     */
    static int toInt(String value) {
        return toInt(value, 0);
    }

    /**
     * 类型转换 string转int
     *
     * @param value 原始值
     * @param def   默认值
     * @return int
     */
    static int toInt(String value, int def) {
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            return def;
        }
    }

    /**
     * 类型转换 String转int
     *
     * @param value 原始值
     * @return
     */
    static long toLong(String value) {
        return toLong(value, 0);
    }


    /**
     * 类型转换 String转int
     *
     * @param value 原始值
     * @param def   默认值
     * @return
     */
    static long toLong(String value, int def) {
        try {
            return Long.parseLong(value);
        } catch (Exception e) {
            return def;
        }
    }

    /**
     * 类型转换String 转 double
     *
     * @param value
     * @return
     */
    static double toDouble(String value) {
        return toDouble(value, 0);
    }

    /**
     * string转Double
     *
     * @param value 原始值
     * @param def   默认值
     * @return
     */
    static double toDouble(String value, int def) {
        try {
            return Double.parseDouble(value);
        } catch (Exception e) {
            return def;
        }
    }

    static float toFloat(String value) {
        return toFloat(value, 0);
    }

    /**
     * string转 Double
     *
     * @param value 原始值
     * @param def   默认值
     * @return
     */
    static float toFloat(String value, int def) {
        try {
            return Float.parseFloat(value);
        } catch (Exception e) {
            return def;
        }
    }

    /**
     * String转boolean
     *
     * @param value
     * @return
     */
    static boolean toBoolean(String value) {
        return toBoolean(value, false);
    }

    /**
     * String 转boolean
     *
     * @param value
     * @param def
     * @return
     */
    static boolean toBoolean(String value, boolean def) {
        try {
            return Boolean.parseBoolean(value);
        } catch (Exception e) {
            return def;
        }
    }
}
