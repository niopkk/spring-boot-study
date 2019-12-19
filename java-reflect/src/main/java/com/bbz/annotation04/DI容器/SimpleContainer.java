package com.bbz.annotation04.DI容器;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * com.bbz.annotation04.DI容器
 * <p>
 * Created by tianxin2 on 2019/12/19
 */
public class SimpleContainer {


    private static Map<Class<?>, Object> instances = new ConcurrentHashMap<>();

    public static <T> T getInstance(Class<T> cls) {
        try {
            final boolean singleton = cls.isAnnotationPresent(SimpleSingleton.class);
            if (!singleton) {
                createInstance(cls);
            }
            Object o = instances.get(cls);
            if (o != null) {
                return (T) o;
            }
            synchronized (cls) {
                o = instances.get(cls);
                if (o == null) {
                    o = createInstance(cls);
                    instances.put(cls, o);
                }
            }
            return (T) o;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static <T> T createInstance(Class<T> cls) {
        try {
            final T obj = cls.newInstance();
            Field[] fields = cls.getDeclaredFields();
            for (Field f : fields) {
                if (f.isAnnotationPresent(SimpleInject.class)) {
                    if (!f.isAccessible()) {
                        f.setAccessible(true);
                    }
                    final Class<?> clsType = f.getType();
                    f.set(obj, getInstance(clsType));
                }
            }
            return obj;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
