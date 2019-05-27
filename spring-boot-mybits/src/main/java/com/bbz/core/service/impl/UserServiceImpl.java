package com.bbz.core.service.impl;

import com.bbz.core.entity.UserEntity;
import com.bbz.core.repository.UserMapper;
import com.bbz.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;
//
//    @Override
//    public List<UserEntity> findUserList() {
//        return userMapper.findUserList();
//    }
//
//    @Override
//    public UserEntity findUserByAccount(String account) {
//        return userMapper.findUserByAccount(account);
//    }
//
//    @Override
//    public UserEntity findUserByUserId(String userId) {
//        return userMapper.findUserByUserId(userId);
//    }

    @Override
    public boolean insertUser(UserEntity entity) {
        return userMapper.insertUser(entity);
    }

//    @Override
//    public boolean updateUser(UserEntity entity) {
//        return userMapper.updateUser(entity);
//    }
//
//    @Override
//    public boolean deleteUserByUserId(String userId) {
//        return userMapper.deleteUserByUserId(userId);
//    }
}
