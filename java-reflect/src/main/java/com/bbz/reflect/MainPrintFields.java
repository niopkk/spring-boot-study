package com.bbz.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class MainPrintFields {

    public static void main(String[] args) {

//        printFields();

        printMethods();
    }

    public static void printMethods() {
        /**
         * 获取类中的所有字段
         */

        Class mClass = SonClass.class;

        System.out.println("获取类的名称:" + mClass.getName());


        Method[] methods = mClass.getMethods();

        for (Method m : methods) {
            //获取并输出方法的访问权限（Modifiers：修饰符）
            int modifiers = m.getModifiers();

            System.out.println(":" + Modifier.toString(modifiers));


            Class returnType = m.getReturnType();
            System.out.print(returnType.getName() + " "
                    + m.getName() + "( ");
            //获取并输出方法的所有参数
            Parameter[] parameters = m.getParameters();
            for (Parameter parameter :
                    parameters) {
                System.out.print(parameter.getType().getName()
                        + " " + parameter.getName() + ",");
            }
            //获取并输出方法抛出的异常
            Class[] exceptionTypes = m.getExceptionTypes();
            if (exceptionTypes.length == 0) {
                System.out.println(" )");
            } else {
                for (Class c : exceptionTypes) {
                    System.out.println(" ) throws "
                            + c.getName());
                }
            }
        }
    }


    public static void printFields() {

        /**
         * 获取类中的所有字段
         */
        Class mClass = SonClass.class;

        System.out.println("获取类的名称:" + mClass.getName());

        //有访问权限
        Field[] fields = mClass.getFields();
        //无访问权限
        //Field[] fields = mClass.getDeclaredFields();

        for (Field f : fields) {
            //获取访问权限并输出
            int modifiers = f.getModifiers();

            System.out.print(Modifier.toString(modifiers) + " :");


            //输出变量的类型及变量名
            System.out.println(f.getType().getName()
                    + " " + f.getName());


        }

    }

}
