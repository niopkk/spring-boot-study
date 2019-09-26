package com.bbz.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * com.bbz.example
 * <p>
 * Created by tianxin2 on 2019-09-26
 */
public class MainTeacherTest {


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {


        //获取类的对象
        Class<?> var1 = Class.forName("com.bbz.example.Teacher");

        //调用方法
        Method method = var1.getMethod("getName", String.class);

        //执行方法(执行非static 方法时需要newInstance() 实例化类)
        method.invoke(var1.newInstance(), "张三");

        Method method1 = var1.getMethod("getSubject", String.class);

        method1.invoke(var1, "数学");


    }
}
