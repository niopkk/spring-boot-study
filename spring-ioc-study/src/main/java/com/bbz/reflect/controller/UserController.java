package com.bbz.reflect.controller;

import com.bbz.reflect.annotation.AutoWried;
import com.bbz.reflect.server.UserService;

public class UserController {

    @AutoWried
    private UserService userService;


    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
