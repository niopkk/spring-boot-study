package com.bbz.spring.controller;

import com.bbz.spring.formework.annotation.Autowired;
import com.bbz.spring.formework.annotation.Controller;
import com.bbz.spring.controller.service.HelloService;

@Controller
public class HelloController {

    @Autowired()
    private HelloService helloService;

    public String say() {
        return helloService.say();
    }
}
