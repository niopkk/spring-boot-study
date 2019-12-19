package com.bbz.annotation04.定制序列化;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * com.bbz.annotation04
 * <p>
 * Created by tianxin2 on 2019/12/19
 */
public class SimpleFormmart {


    public static <T> String format(T t) {
        try {
            final Class<?> cls = t.getClass();
            StringBuilder sb = new StringBuilder();

            for (Field f : cls.getDeclaredFields()) {
                if (!f.isAccessible()) {
                    f.setAccessible(true);
                }
                final AnnotationTest.Lable lable = f.getAnnotation(AnnotationTest.Lable.class);
                String name = lable != null ? lable.value() : f.getName();
                Object value = f.get(t);
                if (value != null && f.getType() == Date.class) {
                    value = formatDate(f, value);
                }
                sb.append(name + ":" + value + "\n");
            }

            return sb.toString();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private static Object formatDate(Field f, Object value) {
        AnnotationTest.Format format = f.getAnnotation(AnnotationTest.Format.class);
        if (format != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(format.pattern());
            sdf.setTimeZone(TimeZone.getTimeZone(format.timezone()));
            return sdf.format(value);
        }
        return value;
    }
}
