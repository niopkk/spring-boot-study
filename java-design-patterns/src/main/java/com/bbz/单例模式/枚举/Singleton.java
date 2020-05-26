package com.bbz.单例模式.枚举;

public enum Singleton {
    INSTANCE;

    public static Singleton getInstance() {
        return INSTANCE;
    }


    public String get(String url) {
        return "ddd" + url;
    }
}
