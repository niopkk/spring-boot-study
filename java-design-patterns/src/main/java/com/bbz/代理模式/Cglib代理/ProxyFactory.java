package com.bbz.代理模式.Cglib代理;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory {


    public <T> T ProxyFactory(Class<T> tager) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(tager);

        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Class<?> ifaceClass = o.getClass().getInterfaces()[0];

                System.out.println("infaClass:" + ifaceClass.getName());

                Class rootClass = ifaceClass.getEnclosingClass();

                System.out.println("rootClass:" + rootClass);

                Object returnValue = method.invoke(tager.newInstance(), objects);

                return returnValue;
            }
        });
        return (T) enhancer.create();
    }


}
