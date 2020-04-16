package com.day_02_spring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LogAspect {


    @Before("execution(* com.day_02_spring.MithImpl.*(..))")
    public void Before() {
        System.out.println("计算开始前");
    }

    @After("execution(* com.day_02_spring.MithImpl.* (..))")
    public void After() {

        System.out.println("方法结束");
    }

    @AfterReturning(value = "execution(* com.day_02_spring.MithImpl.* (..))", returning = "result")
    public void afterReturing(JoinPoint joinPoint, Object result) {

        String methonName = joinPoint.getSignature().getName();

        System.out.println("method:" + methonName + ",args:" + Arrays.toString(joinPoint.getArgs()) + ",result:" + result);
    }

    @AfterThrowing(value = "execution(* com.day_02_spring.MithImpl.* (..))", throwing = "ex")
    public void AfterThrowing(ArithmeticException ex) {
        System.out.println("ex" + ex);
    }

    @Around("execution(* com.day_02_spring.MithImpl.* (..))")
    public Object AroundThring(ProceedingJoinPoint joinPoint) {

        Object result = null;
        try {
            System.out.println("前置通知。。。。。。。");
            result = joinPoint.proceed();
            System.out.println("返回通知。。。。。。。");
            return result;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("错误通知。。。。。。");
        } finally {
            System.out.println("后置通知。。。。。。");
        }

        return -1;
    }
}
