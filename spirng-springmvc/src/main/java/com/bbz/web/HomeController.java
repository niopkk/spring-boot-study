package com.bbz.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * com.bbz.web
 * <p>
 * Created by tianxin2 on 2019-05-24
 */
@Controller
public class HomeController {


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home() {
        return "home";
    }
}
