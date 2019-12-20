package com.bbz.annotation04.aop;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * com.bbz.annotation04.aop
 * <p>
 * Created by tianxin2 on 2019/12/19
 */
public class CGlibContainer {

    public enum InterceptPoint {
        BEFORE, AFTER, EXCEPTION
    }

    static Map<Class<?>, Map<InterceptPoint, List<Method>>> interceptMethodMaps = new HashMap<>();

    static Class<?>[] aspects = new Class<?>[]{ServiceLogAspect.class, ExcepationAspect.class};


    static {
        init();
    }

    private static void init() {

        for (Class<?> cls : aspects) {
            Aspect aspect = cls.getAnnotation(Aspect.class);
            if (aspect != null) {
                final Method before = getMethod(cls, "before", new Class<?>[]{Object.class, Method.class, Object[].class});

                final Method after = getMethod(cls, "after", new Class<?>[]{Object.class, Method.class, Object[].class, Object.class});

                final Method exception = getMethod(cls, "exception", new Class<?>[]{Object.class, Method.class, Object[].class, Throwable.class});


                Class<?>[] intercepttedAddrs = aspect.values();
                for (Class<?> interceptted : intercepttedAddrs) {
                    addIntercepttedMethod(interceptted, InterceptPoint.BEFORE, before);
                    addIntercepttedMethod(interceptted, InterceptPoint.AFTER, after);
                    addIntercepttedMethod(interceptted, InterceptPoint.EXCEPTION, exception);
                }
            }
        }
    }

    private static void addIntercepttedMethod(Class<?> cls, InterceptPoint point, Method method) {
        if (method == null) {
            return;
        }
        Map<InterceptPoint, List<Method>> map = interceptMethodMaps.get(cls);
        if (map == null) {
            map = new HashMap<>();
            interceptMethodMaps.put(cls, map);
        }
        List<Method> methods = map.get(point);
        if (methods == null) {
            methods = new ArrayList<>();
            map.put(point, methods);
        }
        methods.add(method);
    }


    private static Method getMethod(Class<?> cls, String method, Class<?>[] args) {
        try {
            return cls.getMethod(method, args);
        } catch (NoSuchMethodException e) {

            return null;
        }
    }

    private static <T> T createInstance(Class<T> cls) throws IllegalAccessException, InstantiationException {

        if (!interceptMethodMaps.containsKey(cls)) {
            return (T) cls.newInstance();
        }
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(cls);
        enhancer.setCallback(new AspectInterceptor());
        return (T) enhancer.create();
    }

    static class AspectInterceptor implements MethodInterceptor {

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

            //执行before
            List<Method> beforeMethods = getInstanceMethods(o.getClass().getSuperclass(), InterceptPoint.BEFORE);
            for (Method m : beforeMethods) {
                m.invoke(null, new Object[]{o, method, objects});
            }
            try {
                //原始方法
                final Object result = methodProxy.invokeSuper(o, objects);

                //执行after
                final List<Method> afterMethods = getInstanceMethods(o.getClass().getSuperclass(), InterceptPoint.AFTER);
                for (Method m : afterMethods) {
                    m.invoke(null, new Object[]{o, method, objects, result});
                }
                return result;
            } catch (Throwable e) {
                final List<Method> exceptionMethods = getInstanceMethods(o.getClass().getSuperclass(), InterceptPoint.EXCEPTION);
                for (Method m : exceptionMethods) {
                    m.invoke(null, new Object[]{o, method, objects, e});
                }
                throw e;
            }

        }
    }

    private static List<Method> getInstanceMethods(Class<?> cls, InterceptPoint point) {
        final Map<InterceptPoint, List<Method>> map = interceptMethodMaps.get(cls);
        if (map == null) {
            return Collections.emptyList();
        }
        List<Method> methods = map.get(point);
        if (methods == null) {
            return Collections.emptyList();
        }
        return methods;
    }

    public static <T> T getInstance(Class<T> cls) {

        try {
            final T obj = createInstance(cls);
            Field[] fields = cls.getDeclaredFields();
            for (Field f : fields) {
                if (f.isAnnotationPresent(SimpleInject.class)) {
                    if (!f.isAccessible()) {
                        f.setAccessible(true);
                    }
                    final Class<?> fileType = f.getType();
                    f.set(obj, getInstance(fileType));
                }
            }
            return obj;
        } catch (Exception e) {
            throw new RuntimeException();
        }

    }
}
