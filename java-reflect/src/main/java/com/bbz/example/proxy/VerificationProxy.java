package com.bbz.example.proxy;

import com.bbz.example.annotation.Verification;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class VerificationProxy implements InvocationHandler {


    private Class<?> classType;





    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }

//
//    public <T> T getProxyInstance(Class<?> classType) {
//        this.classType = classType;
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(this.classType.getClass());
//        enhancer.setInterfaces(new Class<?>[]{classType});
//        enhancer.setCallback(this);
//        return (T) enhancer.create();
//    }
//
//
//    @Overrideid
//    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//
//        Map<String, Boolean> result = new HashMap<>();
//
//        Verification verification = classType.getAnnotation(Verification.class);
//        if (!verification.validate()) {
//            result.put(classType.getSimpleName(), true);
//        } else {
//            Field[] fields = classType.getDeclaredFields();
//            for (Field field : fields) {
//                if (field.isAnnotationPresent(Verification.class)) {
//                    verification = field.getAnnotation(Verification.class);
//                    if (verification.validate()) {
//                        result.put(field.get(classType).toString(), field.get(classType) != null ? true : false);
//                    }
//                }
//            }
//        }
//        return result;
//    }


//        Class stuCla = (Class) obj.getClass();// 得到类对象
//        Field[] fs = stuCla.getDeclaredFields();//得到属性集合
//        boolean flag = true;
//        for (Field f : fs) 
//
//    {//遍历属性
//            f.setAccessible(true); // 设置属性是可以访问的(私有的也可以)
//            Object val = f.get(obj);// 得到此属性的值
//            if (val != null) {//只要有1个属性不为空,那么就不是所有的属性值都为空
//                flag = false;
//                break;
//            }
//        }
}
