package com.bbz.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MapperProxy implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class<?> returnType = method.getReturnType();
        System.out.println(returnType);
        List<Object> lists = new ArrayList<>();
        lists.add(1);
        lists.add(23);
        lists.add(3);
        return lists;
    }
}
