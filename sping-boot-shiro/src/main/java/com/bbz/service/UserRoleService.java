package com.bbz.service;


import com.bbz.config.base.IService;
import com.bbz.model.UserRole;

public interface UserRoleService extends IService<UserRole> {

	void deleteUserRolesByRoleId(String roleIds);

	void deleteUserRolesByUserId(String userIds);
}
