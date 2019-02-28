package com.bbz.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class HttpAopAdviseDefine {


    //http 权限验证

    @Pointcut("@annotation(com.bbz.annotation.AuthChecker)")
    public void pointcut() {

    }

    @Around("pointcut()")
    public Object checkAuth(ProceedingJoinPoint joinPoint) throws Throwable {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        String token = getUserToken(request);

        if (!token.equalsIgnoreCase("123456")) {
            return "错误, 权限不合法!";
        }
        return joinPoint.proceed();
    }

    private String getUserToken(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();

        if (null == cookies) {
            return "";
        }

        for (Cookie cookie : cookies) {
            if (cookie.getName().equalsIgnoreCase("user_tocken")) {
                return cookie.getValue();
            }
        }

        return "";

    }
}
