package com.bbz.core.service;

import com.bbz.core.entity.UserEntity;

import java.util.List;
import java.util.Map;

public interface UserService {


    List<UserEntity> findUserList();


    List<UserEntity> findUserListByNameOrAccount(String name, String account);


    /**
     * 根据账号查询用户
     *
     * @param account
     * @return
     */
    UserEntity findUserByAccount(String account);

    /**
     * 根据用户id查询
     *
     * @param userId
     * @return
     */
    UserEntity findUserByUserId(String userId);


    Map findUserMapByUserId(String userId);


    /**
     * 新增用户
     *
     * @param entity
     * @return
     */
    boolean insertUser(UserEntity entity);

    /**
     * 修改用户
     *
     * @param
     * @return
     */
    boolean updateUser(UserEntity entity);

    /**
     * 删除用户
     *
     * @param userId
     * @return
     */
    boolean deleteUserByUserId(String userId);
}
