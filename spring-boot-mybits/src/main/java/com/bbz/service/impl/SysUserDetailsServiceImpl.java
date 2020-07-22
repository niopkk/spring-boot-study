package com.bbz.service.impl;

import com.bbz.dao.SysUserDao;
import com.bbz.model.SysPermissions;
import com.bbz.model.SysUser;
import com.bbz.service.SysPermissionsService;
import com.bbz.service.SysUserDetailsService;
import com.bbz.support.TokenDetail;
import com.bbz.support.UserInfo;
import com.bbz.util.Dates;
import com.bbz.util.Lists;
import com.bbz.util.TokenUtils;
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
public class SysUserDetailsServiceImpl implements SysUserDetailsService, UserDetailsService {


    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private SysPermissionsService sysPermissionsService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = findSysUserByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        }

        String authorities = "";
        List<SysPermissions> permissions = sysPermissionsService.findSysPermissionsByRoleId(user.getRoleId());
        if (Objects.nonNull(permissions)) {
            authorities = permissions.stream().map(p -> p.getUrl()).collect(Collectors.joining(","));
        }
        return UserInfo.builder()
                .username(user.getAccount())
                .passWord(user.getPassWord())
                .authorities(AuthorityUtils.commaSeparatedStringToAuthorityList(authorities))
                .lastPasswordReset(Dates.addDays(new Date(), -1))
//                .enabled(user.getStatus() == 0)
                .build();
    }

    @Override
    public SysUser findSysUserByUserName(String userName) {
        return sysUserDao.findSysUserByUserName(userName);
    }

    @Override
    public String generateToken(TokenDetail tokenDetail) {
        return tokenUtils.generateToken(tokenDetail);
    }

}
