package com.bbz.reflect;

import com.bbz.reflect.annotation.AutoWried;
import com.bbz.reflect.controller.UserController;
import org.junit.Test;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Type;
import java.util.stream.Stream;

public class ControllerTest {


    @Test
    public void test() {

        UserController userController = new UserController();

        Class<? extends UserController> classzz = userController.getClass();
        Stream.of(classzz.getDeclaredFields()).forEach(field -> {
            if (field.isAnnotationPresent(AutoWried.class)) {
                field.setAccessible(true);
                Class<?> type = field.getType();
                try {
                    Object o = type.newInstance();
                    field.set(userController, o);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println(userController.getUserService());

    }
}
