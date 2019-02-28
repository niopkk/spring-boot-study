package com.bbz.controller;


import com.bbz.annotation.AuthChecker;
import com.bbz.core.service.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private SomeService someService;

    @RequestMapping("/aop/http/alive")
    public String alive() {
        return "服务一切正常";
    }

    @AuthChecker
    @RequestMapping("/aop/http/user_info")
    public String callSomeInterface() {
        return "调用了 user_info 接口.";
    }

    @RequestMapping("/aop/statistics/time")
    public String statistics() {
        someService.someMethod();
        return "server 时间统计";
    }





}
