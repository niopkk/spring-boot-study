package com.bbz.util;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public interface Maps {

    /**
     * 获取Map中的值
     *
     * @param value 原始Map
     * @param key   数据的键
     * @return int
     */
    static int toInt(Map<?, ?> value, String key) {
        return toInt(value, key, 0);
    }

    /**
     * 获取Map中的值
     *
     * @param value 原始Map
     * @param key   数据的键
     * @param def   默认值
     * @return int
     */
    static int toInt(Map<?, ?> value, String key, int def) {
        if (value != null && value.containsKey(key)) {
            return Strings.toInt(toStr(value, key), def);
        } else {
            return def;
        }
    }

    /**
     * 获取Map中的值
     *
     * @param value 原始Map
     * @param key   数据的键
     * @return java.lang.String
     */
    static String toStr(Map<?, ?> value, String key) {
        return toStr(value, key, null);
    }

    /**
     * 获取Map中的值
     *
     * @param value 原始Map
     * @param key   数据的键
     * @param def   默认值
     * @return java.lang.String
     */
    static String toStr(Map<?, ?> value, String key, String def) {
        if (value != null && value.containsKey(key)) {
            return String.valueOf(value.get(key));
        } else {
            return def;
        }
    }

    /**
     * 获取Map中的值
     *
     * @param value 原始Map
     * @param key   数据的键
     * @param def   默认值
     * @return long
     */
    static long toLong(Map<?, ?> value, String key, int def) {
        if (value != null && value.containsKey(key)) {
            return Strings.toLong(toStr(value, key));
        } else {
            return def;
        }
    }

    /**
     * 获取Map中的值
     *
     * @param value 原始Map
     * @param key   数据的键
     * @return long
     */
    static long toLong(Map<?, ?> value, String key) {
        return toLong(value, key, 0);
    }

    /**
     * Map取boolean的值
     *
     * @param value
     * @param key
     * @return
     */
    static boolean toBoolean(Map<?, ?> value, String key) {
        return toBoolean(value, key, false);
    }

    /**
     * Map取boolean值
     *
     * @param value
     * @param key
     * @param def
     * @return
     */
    static boolean toBoolean(Map<?, ?> value, String key, boolean def) {
        if (value != null && value.containsKey(key)) {
            return Strings.toBoolean(key, def);
        } else {
            return def;
        }
    }


//    /**
//     * 获取Map中的值
//     *
//     * @param value 原始Map
//     * @param key   数据的键
//     * @param def   默认值
//     * @return java.util.List<?>
//     */
//    public static List<?> getList(Map<?, ?> value, String key, List<?> def) {
//        if (value != null && value.containsKey(key)) {
//            Object obj = value.get(key);
//            if (obj instanceof List) {
//                return (List<?>) obj;
//            } else if (obj instanceof String) {
//                JSONArray array = JSON.parseArray((String) obj);
//                List<Map<String, Object>> tempList = new ArrayList<>();
//                for (int i = 0; i < array.size(); i++) {
//                    tempList.add(array.getJSONObject(i));
//                }
//                return tempList;
//            } else {
//                return def;
//            }
//        } else {
//            return def;
//        }
//    }
}
