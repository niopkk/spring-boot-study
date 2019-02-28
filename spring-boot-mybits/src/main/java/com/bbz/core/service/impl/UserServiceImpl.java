package com.bbz.core.service.impl;

import com.bbz.core.entity.UserEntity;
import com.bbz.core.repository.UserRepository;
import com.bbz.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity findUserByAccount(String account) {
        return userRepository.findUserByAccount(account);
    }

    @Override
    public UserEntity findUserByUserId(String userId) {
        return userRepository.findUserByUserId(userId);
    }

    @Override
    public boolean insertUser(UserEntity entity) {
        return userRepository.insertUser(entity);
    }

    @Override
    public boolean updateUser(UserEntity entity) {
        return userRepository.updateUser(entity);
    }

    @Override
    public boolean deleteUserByUserId(String userId) {
        return userRepository.deleteUserByUserId(userId);
    }
}
