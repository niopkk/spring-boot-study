package com.bbz.代理模式.Cglib代理;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory implements MethodInterceptor {


    private Object tager;

    public ProxyFactory(Object tager) {
        this.tager = tager;
    }

    public Object getProxyInstance() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(tager.getClass());
        enhancer.setInterfaces(this.getClass().getInterfaces());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object target, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Class<?> ifaceClass = target.getClass().getInterfaces()[0];

        System.out.println("infaClass:" + ifaceClass.getName());

        Class rootClass = ifaceClass.getEnclosingClass();

        System.out.println("rootClass:" + rootClass);

        Object returnValue = method.invoke(tager, objects);

        return returnValue;
    }
}
