package com.bbz.dao;


import com.bbz.config.MyMapper;
import com.bbz.model.User;
import com.bbz.model.UserWithRole;

import java.util.List;

public interface UserMapper extends MyMapper<User> {

	List<User> findUserWithDept(User user);
	
	List<UserWithRole> findUserWithRole(Long userId);
	
	User findUserProfile(User user);
}