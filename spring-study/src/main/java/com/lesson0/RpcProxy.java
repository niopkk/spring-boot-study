package com.lesson0;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class RpcProxy implements InvocationHandler {

    private Object object;

    public RpcProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


        method.invoke(object, args);
        System.out.println("ddddsdddd");
        return null;
    }
}
