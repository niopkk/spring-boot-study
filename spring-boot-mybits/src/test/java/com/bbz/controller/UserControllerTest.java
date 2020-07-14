//package com.bbz.controller;
//
//
///**
// * com.bbz.controller
// * <p>
// * Created by tianxin2 on 2019-05-27
// */
//
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class UserControllerTest {
//
//    @Autowired
//    private UserService userService;
//
//    @Test
//    public void getUserList() {
//        userService.findUserList();
//    }
//
//    @Test
//    public void store() {
//        UserEntity userEntity = new UserEntity()
//                .setName("张三123")
//                .setAccount("1333")
//                .setPassWord("124")
//                .setCreateTime(System.currentTimeMillis())
//                .setSex(1)
//                .setStatus(1)
//                .setUpdateTime(System.currentTimeMillis());
//
//        userService.insertUser(userEntity);
//    }
//
//    @Test
//    public void getById() {
//        userService.findUserByUserId("2");
//    }
//
//    @Test
//    public void getUserMapByUserId() {
//        userService.findUserMapByUserId("1");
//    }
//
//    @Test
//    public void update() {
//        UserEntity userEntity = new UserEntity();
//        userEntity.setId(2);
//        userEntity.setName("历史1");
//        userEntity.setAccount("1786888");
//        userEntity.setCreateTime(System.currentTimeMillis());
//        userEntity.setPassWord("4344");
//        userEntity.setSex(2);
//        userEntity.setStatus(2);
//        userEntity.setUpdateTime(System.currentTimeMillis());
//        userService.updateUser(userEntity);
//    }
//
//    @Test
//    public void findUserListByNameOrAccount() {
//
//        final List<UserEntity> list = userService.findUserListByNameOrAccount("张", "");
//    }
//
//    @Test
//    public void del() {
//        userService.deleteUserByUserId("2");
//    }
//}