package com.bbz;


import com.bbz.core.service.NeedLogService;
import com.bbz.core.service.NormalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application {


    public static void main(String[] args) {

        SpringApplication.run(Application.class);
    }


    //aspect:有pointcut(切点)和advice(通知)组成，它既包含了横切逻辑的定义，也包含了连接点的定义，
    //       spring aop 就是负责实施切面的框架，它将切面所定义的横切逻辑织入到切面所指定的连接点中。
    //advice:由aspect添加到特定的join point(即满足 point cut 规则的 join point)
    //切点可以理解为定义规则，比如那些package下的方法需要

    @Autowired
    private NeedLogService needLogService;

    @Autowired
    private NormalService normalService;

    @PostConstruct
    public void test() {
        needLogService.logMethod("xys");
        try {
            needLogService.exceptionMethod();
        } catch (Exception e) {
            // Ignore
        }
        normalService.someMethod();
    }

}
