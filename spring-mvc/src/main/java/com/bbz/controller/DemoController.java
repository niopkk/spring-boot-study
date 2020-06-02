package com.bbz.controller;

import com.bbz.annotation.Autowired;
import com.bbz.annotation.Controller;
import com.bbz.annotation.RequestMapping;
import com.bbz.annotation.Requestparam;
import com.bbz.service.IDemoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private IDemoService demoService;


    @RequestMapping("/get")
    public String get(@Requestparam(value = "name") String name,
                      HttpServletRequest httpServletRequest,
                      HttpServletResponse httpServletResponse) {
        return demoService.get(name);
    }
}
