package com.bbz.代理模式.代理案例;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

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

//        checkPopedom();


        System.out.println("proxy_Name:" + proxy.getClass().getName());

        System.out.println("method:" + method.getName());

        Class<?> returnType = method.getReturnType();

        System.out.println("returnType:" + returnType.getName());

        System.out.println("args:" + Arrays.toString(args));
        Class<?>[] parameterTypes = method.getParameterTypes();//获取参数类型

        for (Class classzz : parameterTypes) {
            System.out.println("paramterType:" + classzz.getName());
        }

        System.out.println("..................................");

        result = method.invoke(tager, args);

//        checkPopedom();
//        System.out.println("result=" + result);


        return result;
    }

    private void checkPopedom() {
        System.out.println("检查权限!!!");
    }
}
