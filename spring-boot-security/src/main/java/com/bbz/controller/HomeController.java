package com.bbz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {


    @RequestMapping(value = {"/r/p1"}, method = RequestMethod.GET)
    public String index() {

        return "张三拥有p1权限";
    }

    @RequestMapping(value = {"/r/p2"}, method = RequestMethod.GET)
    public String p2() {

        return "lis拥有p2权限";
    }
    @RequestMapping(value = {"/p3"}, method = RequestMethod.GET)
    public String p3() {

        return "lis拥有p3权限";
    }
}
