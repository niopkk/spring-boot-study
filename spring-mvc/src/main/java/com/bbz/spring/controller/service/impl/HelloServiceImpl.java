package com.bbz.spring.controller.service.impl;

import com.bbz.spring.formework.annotation.Service;
import com.bbz.spring.controller.service.HelloService;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String say() {
        return "测试接口的方式方法的";
    }
}
