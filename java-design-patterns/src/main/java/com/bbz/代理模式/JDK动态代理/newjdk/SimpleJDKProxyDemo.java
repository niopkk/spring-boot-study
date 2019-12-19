package com.bbz.代理模式.JDK动态代理.newjdk;

import java.lang.reflect.*;
import java.util.Arrays;

/**
 * com.bbz.代理模式.JDK动态代理.newjdk
 * <p>
 * Created by tianxin2 on 2019/12/19
 */
public class SimpleJDKProxyDemo {

    interface IService {

        void sayHello(String name);

        String returnVal(String name);
    }

    static class RealService implements IService {

        @Override
        public void sayHello(String name) {
            System.out.println("hello..." + name);
        }

        @Override
        public String returnVal(String name) {
            return "return " + name;
        }

    }

    static class SimpleInvocationHandler implements InvocationHandler {

        private Object realObj;

        public SimpleInvocationHandler(Object realObj) {
            this.realObj = realObj;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("开始" + method.getName() + ":" + Arrays.toString(args));
            final Object result = method.invoke(realObj, args);
            System.out.println("结束" + method.getName());
            System.out.println("result：" + result);
            return result;
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        IService service = new RealService();
        final IService o = (IService) Proxy.newProxyInstance(IService.class.getClassLoader(),
                new Class[]{IService.class},
                new SimpleInvocationHandler(service));
        o.sayHello("张三");
        o.returnVal("如何是好");
//        final Class<?> proxyClass = Proxy.getProxyClass(IService.class.getClassLoader(), new Class[]{IService.class});

//        final Constructor<?> constructor = proxyClass.getConstructor(new Class[]{InvocationHandler.class});
//        InvocationHandler invocationHandler = new SimpleInvocationHandler(service);
//        final IService newInstance = (IService) constructor.newInstance(invocationHandler);
//        newInstance.sayHello("李四");
//        newInstance.returnVal("如何是好 李四");

    }

}
