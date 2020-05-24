package com.bbz.controller;

import com.bbz.server.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PublicController {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {


        return "/login";
    }
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String log(String username,String password) {
//
//        final CustomUser customUserByUserNameAndPassWord = customUserDetailsService.findCustomUserByUserNameAndPassWord(username, password);
//
//        return "/login";
//    }

}
