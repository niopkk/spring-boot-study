package com.bbz.annotation04.aop;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * com.bbz.annotation04.aop
 * <p>
 * Created by tianxin2 on 2019/12/19
 */
@Aspect(values = {ServiceB.class})
public class ExcepationAspect {

    public static void exception(Object object, Method method, Object[] args, Throwable e) {
        System.out.println("exception when calling :" + method.getName() + "" +
                ",args" + Arrays.toString(args));
    }
}
