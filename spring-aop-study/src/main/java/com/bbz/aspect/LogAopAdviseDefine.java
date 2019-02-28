package com.bbz.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAopAdviseDefine {

    //日志
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("within(com.bbz.core.service.NeedLogService)")
    public void pointcut(){
    }

    @Before("pointcut()")
    public void logMethodInvokeParam(JoinPoint joinPoint){
        logger.info("---Before method {} invoke, param: {}---", joinPoint.getSignature().toShortString(), joinPoint.getArgs());
    }
    @AfterReturning(pointcut = "pointcut()", returning = "retVal")
    public void logMethodInvokeResult(JoinPoint joinPoint, Object retVal) {
        logger.info("---After method {} invoke, result: {}---", joinPoint.getSignature().toShortString(), joinPoint.getArgs());
    }

    @AfterThrowing(pointcut = "pointcut()", throwing = "exception")
    public void logMethodInvokeException(JoinPoint joinPoint, Exception exception) {
        logger.info("---method {} invoke exception: {}---", joinPoint.getSignature().toShortString(), exception.getMessage());
    }
}
