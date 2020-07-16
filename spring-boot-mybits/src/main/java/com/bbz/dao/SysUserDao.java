package com.bbz.dao;

import com.bbz.entity.SysUserRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserDao {


    SysUserRole findSysUserByUserName(String userName);
}
