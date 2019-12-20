package com.bbz.annotation04.aop;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * com.bbz.annotation04.aop
 * <p>
 * Created by tianxin2 on 2019/12/19
 */
@Aspect(values = {ServiceA.class, ServiceB.class})
public class ServiceLogAspect {


    public static void before(Object object, Method method, Object[] args) {
        System.out.println("entering:" + method.getDeclaringClass().getSimpleName() + "::"
                + method.getName() + ",args:" + Arrays.toString(args));
    }

    public static void after(Object object, Method method, Object[] args, Object result) {
        System.out.println("leaving:" + method.getDeclaringClass().getSimpleName() + "::"
                + method.getName() + ",args:" + Arrays.toString(args) + ",result" + result);
    }
}
