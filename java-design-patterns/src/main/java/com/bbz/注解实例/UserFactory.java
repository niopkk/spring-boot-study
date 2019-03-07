package com.bbz.注解实例;


public class UserFactory {


    public static void createUser(Class<?> classType) {


        Init init = classType.getAnnotation(Init.class);
        if(init!=null){
            System.out.println(init.name() + "：" + init.value());
        }
//        if (null != fields) {
//            for (Field field : fields) {
//                if (field.isAnnotationPresent(Init.class)) {
//                    Init init = field.getAnnotation(Init.class);
//
//                    System.out.println(init.name() + "：" + init.value());
//
//                }
//            }
//        }
    }
}
