package com.bbz.service;

import com.bbz.model.SysUser;
import com.bbz.support.TokenDetail;

public interface SysUserDetailsService {

    SysUser findSysUserByUserName(String userName);

    String generateToken(TokenDetail tokenDetail);
}
