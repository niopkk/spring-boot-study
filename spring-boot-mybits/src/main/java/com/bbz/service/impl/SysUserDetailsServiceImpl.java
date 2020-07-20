package com.bbz.service.impl;

import com.bbz.dao.SysUserDao;
import com.bbz.model.SysPermissions;
import com.bbz.model.SysUser;
import com.bbz.service.SysPermissionsService;
import com.bbz.service.SysUserDetailsService;
import com.bbz.support.UserInfo;
import com.bbz.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SysUserDetailsServiceImpl implements SysUserDetailsService {


    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    private SysPermissionsService sysPermissionsService;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        SysUser user = findSysUserByUserName(username);
//        if (user == null) {
//            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
//        }
//
//        String authorities = "";
//        List<SysPermissions> permissions = sysPermissionsService.findSysPermissionsByRoleId(user.getRoleId());
//        if (Objects.nonNull(permissions)) {
//            authorities = permissions.stream().map(p -> p.getUrl()).collect(Collectors.joining(","));
//        }
//        return UserInfo.builder()
//                .username(user.getAccount())
//                .passWord(user.getPassWord())
//                .authorities(AuthorityUtils.commaSeparatedStringToAuthorityList(authorities))
//                .lastPasswordReset(new Date())
//                .enabled(user.getStatus() > 0)
//                .build();
//    }

    @Override
    public SysUser findSysUserByUserName(String userName) {
        return sysUserDao.findSysUserByUserName(userName);
    }

}
