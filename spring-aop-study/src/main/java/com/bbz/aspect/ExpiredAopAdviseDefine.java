package com.bbz.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class ExpiredAopAdviseDefine {

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Pointcut("within(com.bbz.core.service.SomeService)")
    public void poincut() {
    }


    @Around("poincut()")
    public Object methodInvokeExpiredTime(ProceedingJoinPoint joinPoint) throws Throwable {


        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        // 开始
        Object retVal = joinPoint.proceed();
        stopWatch.stop();
        // 结束

        // 上报到公司监控平台
        reportToMonitorSystem(joinPoint.getSignature().toShortString(), stopWatch.getTotalTimeMillis());

        return retVal;

    }

    private void reportToMonitorSystem(String methodName, long expiredTime) {
        logger.info("---method {} invoked, expired time: {} ms---", methodName, expiredTime);
    }


}
