package com.bbz.代理模式.JDK动态代理.没有实现类的代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class NotImplProxy {

    interface ISing {
        String say();
    }

    public static <T> T getProxy(Class<T> tager) {
        return (T) Proxy.newProxyInstance(tager.getClassLoader(), new Class[]{tager}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return "返回一个html川";
            }
        });
    }
}
