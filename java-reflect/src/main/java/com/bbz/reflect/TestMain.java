package com.bbz.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestMain {


    public static void main(String[] args) throws Exception {
        getPrivateMethod();
//        modifyPrivateFiled();
    }


    private static void modifyPrivateFiled() throws Exception {

        TestClass testClass = new TestClass();
        Class mClass = testClass.getClass();

        Field privateField = mClass.getDeclaredField("MSG");

        if (privateField != null) {
            privateField.setAccessible(true);

            System.out.println("修改前MSG=" + testClass.getMSG());


            privateField.set(testClass, "Modify");


            System.out.println("修改后MSG=" + testClass.getMSG());
        }

    }


    private static void getPrivateMethod() throws Exception {

        //1.获取class实例
        TestClass testClass = new TestClass();
        Class mClass = testClass.getClass();

        //2.获取私有方法
        //第一个参数获取私有方法的名称
        //第二参数获取方法参数的类型
        Method method = mClass.getDeclaredMethod("privateMethod", String.class, int.class);


        //开始操作方法
        if (method != null) {
            //获取私有方法的访问权限，只获取访问权限，不改变实际权限
            method.setAccessible(true);

            //使用invoke反射调用私有方法
            //method是获取到私有方法
            //testClass 要操作的对象
            //后面两个参数传实参
            method.invoke(testClass, "Java Reflect", 666);
        }

    }
}
