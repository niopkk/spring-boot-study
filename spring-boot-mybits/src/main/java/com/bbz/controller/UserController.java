package com.bbz.controller;

import com.bbz.core.entity.UserEntity;
import com.bbz.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<UserEntity> getUserList() {

        return userService.findUserList();
    }

    @RequestMapping(value = "/store", method = RequestMethod.GET)
    public void store() {

        UserEntity userEntity = new UserEntity();
        userEntity.setName("张三");
        userEntity.setAccount("1333");
        userEntity.setCreateTime(System.currentTimeMillis());
        userEntity.setPassWord("123");
        userEntity.setSex(1);
        userEntity.setStatus(1);
        userEntity.setUpdateTime(System.currentTimeMillis());
        userService.insertUser(userEntity);
    }


}
