package com.bbz.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
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

        Method method2 = var1.getDeclaredMethod("getSex", String.class);
        method2.setAccessible(true);
        method2.invoke(var1.newInstance(), "男");


        Constructor<?> constructor1 = var1.getConstructor(new Class[]{Integer.class});
        Teacher teacher = (Teacher) constructor1.newInstance(111111);
        System.out.println(teacher.getAge());

        Constructor<?> constructor = var1.getConstructor(new Class[]{String.class});

        Teacher o = (Teacher) constructor.newInstance("1111221221");


        Constructor<?> declaredConstructor = var1.getDeclaredConstructor(new Class[]{String.class, String.class});
        declaredConstructor.setAccessible(true);
        final Object o1 = declaredConstructor.newInstance("1", "1");


        Field[] fields = var1.getDeclaredFields();
        for (Field field : fields) {

            System.out.println(field.getType());
            if (field.getType().getName().equals("int")) {

                System.out.println("属性类型:" + field.getType());
            }

            System.out.println("属性:" + field.getName());
        }


    }
}
