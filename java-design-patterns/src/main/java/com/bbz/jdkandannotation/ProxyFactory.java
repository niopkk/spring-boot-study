package com.bbz.jdkandannotation;

import com.bbz.jdkandannotation.annotation.RpcClient;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory implements InvocationHandler {


    public static <T> T newMapperProxy(Class<T> mapperInterface) {
        ClassLoader classLoader = mapperInterface.getClassLoader();
        Class<?>[] interfaces = new Class[]{mapperInterface};
        ProxyFactory proxy = new ProxyFactory();
        return (T) Proxy.newProxyInstance(classLoader, interfaces, proxy);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        RpcClient rpcClient = method.getDeclaringClass().getAnnotation(RpcClient.class);
        System.out.println("rpcClient:" + rpcClient.value());

//        if (annotationconfig != null) {
//            Method[] met = annotationconfig.annotationType().getDeclaredMethods();
//            for(Method me : met ){
//                if(!me.isAccessible()){
//                    me.setAccessible(true);
//                }
//                try {
//                    System.out.println(me.invoke(annotationconfig, args));
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                } catch (IllegalArgumentException e) {
//                    e.printStackTrace();
//                } catch (InvocationTargetException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

//        Object result = method.invoke(tager, args);


        return null;
    }
}
