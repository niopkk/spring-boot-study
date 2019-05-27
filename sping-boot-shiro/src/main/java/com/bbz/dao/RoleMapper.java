package com.bbz.dao;


import com.bbz.config.MyMapper;
import com.bbz.model.Role;
import com.bbz.model.RoleWithMenu;

import java.util.List;

public interface RoleMapper extends MyMapper<Role> {
	
	List<Role> findUserRole(String userName);
	
	List<RoleWithMenu> findById(Long roleId);
}