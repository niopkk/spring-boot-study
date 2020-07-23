package com.bbz.service;

import com.bbz.model.User;
import com.bbz.search.Params;

import java.util.List;

public interface UserService {

    List<User> findAll();

    List<User> findAll(int pageNum, int pageSize, User user);

    List<User> findAll(int pageNum, int pageSize, Params params);
}
