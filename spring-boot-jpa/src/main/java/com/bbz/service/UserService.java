package com.bbz.service;

import com.bbz.model.UserModel;
import com.bbz.search.UserSearchTerm;

import java.util.List;

public interface UserService {

    /**
     * 查询全部
     *
     * @return
     */
    List<UserModel> findUserAll();

    /**
     * 多条件查找
     *
     * @param term
     * @return
     */
    List<UserModel> findUserAll(UserSearchTerm term);


    /**
     * 单个条件查找
     *
     * @param id
     * @return
     */
    UserModel findUserById(int id);

    /**
     * 保存
     *
     * @param userModel
     */
    void save(UserModel userModel);
}
