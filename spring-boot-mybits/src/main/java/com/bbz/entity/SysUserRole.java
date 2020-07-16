package com.bbz.entity;

import com.bbz.model.SysUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class SysUserRole extends SysUser implements UserDetails {


    private Collection<? extends GrantedAuthority> authorities;

    public SysUserRole() {
    }

    public SysUserRole(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return super.getPassWord();
    }

    @Override
    public String getUsername() {
        return super.getAccount();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return super.getStatus() > 0;
    }
}
