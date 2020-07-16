package com.bbz.service;

import com.bbz.model.SysUser;

public interface SysUserDetailsService {

    SysUser findSysUserByUserName(String userName);
}
