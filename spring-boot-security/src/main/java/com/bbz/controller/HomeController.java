package com.bbz.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {


    @RequestMapping(value = {"/r/r1"}, method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('/r/p1')")//拥有p1权限才可以访问
    public String index() {

        return "张三拥有p1权限";
    }

    @RequestMapping(value = {"/r/r2"}, method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('/r/p2')")//拥有p1权限才可以访问
    public String p2() {

        return "lis拥有p2权限";
    }

    @RequestMapping(value = {"/r3"}, method = RequestMethod.GET)
    public String p3() {

        return "lis拥有p3权限";
    }
}
