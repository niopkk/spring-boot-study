package com.bbz.builder;

/**
 * 通过私有构造器强化不可实例化的能力
 */
public class UtilityClass {

    private UtilityClass() {
    }

    public static String getUrl() {
        return null;
    }
}
