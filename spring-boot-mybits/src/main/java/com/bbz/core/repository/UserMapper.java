package com.bbz.core.repository;

import com.bbz.core.entity.UserEntity;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface UserMapper {


    /**
     * 查询用户数据列表
     *
     * @return
     */
    Page<UserEntity> findUserList();

    List<UserEntity> findUserListByNameOrAccount(@Param("name") String name, @Param("account") String account);


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
