package com.bbz.util;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public interface Maps {


    static <K, V> Map<K, V> of(K k1, V v1) {
        return entries(Entry.of(k1, v1));
    }

    static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2) {
        return entries(Entry.of(k1, v1), Entry.of(k2, v2));
    }

    static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3) {
        return entries(Entry.of(k1, v1), Entry.of(k2, v2), Entry.of(k3, v3));
    }

    static <K, V> Map<K, V> entries(Entry<K, V>... entries) {
        Map<K, V> linkedHashMap = new LinkedHashMap<>();
        for (Entry<K, V> entry : entries) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        return linkedHashMap;
    }

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

    /**
     * map 按key排序
     *
     * @param map
     * @param <K>
     * @param <V>
     * @return
     */
    static <K extends Comparable<? super K>, V> Map<K, V> sortByKey(Map<K, V> map) {
        return sortByKey(map, desc());
    }

    static <K extends Comparable<? super K>, V> Comparator<Map.Entry<K, V>> desc() {
        return Map.Entry.<K, V>comparingByKey()
                .reversed();
    }

    static <K extends Comparable<? super K>, V> Comparator<Map.Entry<K, V>> asc() {
        return Map.Entry.comparingByKey();

    }

    /**
     * map 按key排序
     *
     * @param map
     * @param <K>
     * @param <V>
     * @return
     */
    static <K extends Comparable<? super K>, V> Map<K, V> sortByKey(Map<K, V> map, Comparator<Map.Entry<K, V>> sort) {
        Map<K, V> result = new LinkedHashMap<>();
        map.entrySet().stream()
                .sorted(sort).forEachOrdered(e -> result.put(e.getKey(), e.getValue()));


        return result;
    }

    /**
     * map 按value排序
     *
     * @param map
     * @param <K>
     * @param <V>
     * @return
     */
    static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        Map<K, V> result = new LinkedHashMap<>();

        map.entrySet().stream()
                .sorted(Map.Entry.<K, V>comparingByValue()
                        .reversed()).forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        return result;
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
