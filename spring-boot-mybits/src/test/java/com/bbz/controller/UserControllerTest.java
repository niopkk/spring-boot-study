package com.bbz.controller;


/**
 * com.bbz.controller
 * <p>
 * Created by tianxin2 on 2019-05-27
 */

import com.bbz.core.entity.UserEntity;
import com.bbz.core.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Autowired
    private UserService userService;

    @Test
    public void getUserList() {
        userService.findUserList();
    }

    @Test
    public void  store(){
        UserEntity userEntity = new UserEntity();
        userEntity.setName("张三123");
        userEntity.setAccount("1333");
        userEntity.setCreateTime(System.currentTimeMillis());
        userEntity.setPassWord("123");
        userEntity.setSex(1);
        userEntity.setStatus(1);
        userEntity.setUpdateTime(System.currentTimeMillis());
        userService.insertUser(userEntity);
    }
    @Test
    public void update(){

        UserEntity userEntity = new UserEntity();
        userEntity.setId(2);
        userEntity.setName("历史1");
        userEntity.setAccount("1786888");
        userEntity.setCreateTime(System.currentTimeMillis());
        userEntity.setPassWord("4344");
        userEntity.setSex(2);
        userEntity.setStatus(2);
        userEntity.setUpdateTime(System.currentTimeMillis());
        userService.updateUser(userEntity);
    }
}