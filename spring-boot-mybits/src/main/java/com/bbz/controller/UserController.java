package com.bbz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {


    @RequestMapping("/user")
    public Map<String, Object> getUserList() {
        return null;
    }



}
