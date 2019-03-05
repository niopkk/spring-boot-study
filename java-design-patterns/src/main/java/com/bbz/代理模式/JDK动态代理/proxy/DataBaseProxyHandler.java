package com.bbz.代理模式.JDK动态代理.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DataBaseProxyHandler<T> implements InvocationHandler {


    /**
     * 被代理的对象
     */
    private Object tager;

    /**
     * 需要去做事情的接口
     */
    private ProxyInterface proxyInterface;

    /**
     * 需要去做事情的类
     */
    private Object params;

    public DataBaseProxyHandler(Object v) {
        this.params = v;
    }

    public T proxy(T tager, ProxyInterface proxyInterface) {
        this.tager = tager;
        this.proxyInterface = proxyInterface;
        return (T) Proxy.newProxyInstance(
                this.tager.getClass().getClassLoader()
                , this.proxyInterface.getClass().getInterfaces()
                , this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println(proxy.getClass().getName());

        Object obj = null;
        obj = method.invoke(this.tager, args);

        if (args != null && args.length > 0) {
            proxyInterface.doEnd(obj, params, args);
        } else {
            proxyInterface.doEnd(obj, params, null);
        }

        return obj;
    }
}
