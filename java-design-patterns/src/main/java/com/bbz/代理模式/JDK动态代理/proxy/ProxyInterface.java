package com.bbz.代理模式.JDK动态代理.proxy;

public interface ProxyInterface<T, V> {


    /**
     * 结束后需要操作的事
     *
     * @param returnObj
     * @param t
     * @param param
     * @return
     */
    Object doEnd(V returnObj, T t, Object[] param);
}
