package com.bbz.注解实例;



import com.bbz.注解实例.model.User;

import java.lang.reflect.Field;

public class UserFactory {


    public static User createUser() {

        User user = new User();

        Field[] fields = user.getClass().getDeclaredFields();
        if (null != fields) {
            for (Field field : fields) {
                if (field.isAnnotationPresent(Init.class)) {
                    Init init = field.getAnnotation(Init.class);

                    user.setName(init.value());


                    return user;
                }
            }
        }
        return null;
    }
}
