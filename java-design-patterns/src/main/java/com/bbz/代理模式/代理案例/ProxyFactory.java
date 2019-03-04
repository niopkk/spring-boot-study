package com.bbz.代理模式.代理案例;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory implements InvocationHandler {

    private Object tager;


    public Object proxy(Object tager) {
        this.tager = tager;

        return Proxy.newProxyInstance(this.tager.getClass().getClassLoader()
                , this.tager.getClass().getInterfaces(), this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;

        checkPopedom();

        result = method.invoke(tager, args);

//        checkPopedom();
        System.out.println("result=" + result);


        return result;
    }

    private void checkPopedom() {
        System.out.println("检查权限!!!");
    }
}
