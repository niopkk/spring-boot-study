package com.bbz.annotation02;

import java.lang.reflect.Field;

public class FruitInfoUtil {

    public static String getFruitInfo(Class<?> clazz) {

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(FruitName.class)) {
                FruitName fruitName = field.getAnnotation(FruitName.class);
                String value = fruitName.value();
                return value;
            } else if (field.isAnnotationPresent(FruitColor.class)) {
                FruitColor fruitColor = field.getAnnotation(FruitColor.class);

                return fruitColor.fruitColor().toString();
            } else if (field.isAnnotationPresent(FruitProvider.class)) {
                FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
                String strFruitProvicer = " 供应商编号：" + fruitProvider.id() + " 供应商名称：" + fruitProvider.name() + " 供应商地址：" + fruitProvider.address();
                return strFruitProvicer;
            }
        }
        return null;
    }
}
