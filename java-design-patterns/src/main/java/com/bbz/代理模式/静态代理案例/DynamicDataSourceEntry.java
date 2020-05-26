package com.bbz.代理模式.静态代理案例;

public class DynamicDataSourceEntry {

    /**
     * 默认数据源
     */
    public final static String DEFAULT_SOURCE = null;

    private final static ThreadLocal<String> local = new ThreadLocal<>();

    private DynamicDataSourceEntry() {
    }

    /**
     * 清空数据源
     */
    public static void clear() {
        local.remove();
    }

    /**
     * 获取数据源
     *
     * @return
     */
    public static String get() {
        return local.get();
    }

    /**
     * 还原当前切换的数据源
     */
    public static void restore() {
        local.set(DEFAULT_SOURCE);
    }

    public static void set(int year) {
        local.set("DB_" + year);
    }
}
