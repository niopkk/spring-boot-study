package com.bbz.reflect;


import com.bbz.reflect.annotation.Autowired;
import com.bbz.reflect.controller.UserController;
import org.junit.Test;

import java.util.stream.Stream;

public class UserControllerTest {

    @Test
    public void test() {

        UserController userController = new UserController();
        Class<? extends UserController> classzz = userController.getClass();
        Stream.of(classzz.getDeclaredFields()).forEach(field -> {
            Autowired annotation = field.getAnnotation(Autowired.class);
            if (null != annotation) {
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
