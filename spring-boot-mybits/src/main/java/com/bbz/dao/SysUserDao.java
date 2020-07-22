package com.bbz.dao;

import com.bbz.model.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserDao {


    SysUser findSysUserByUserName(String userName);
}
