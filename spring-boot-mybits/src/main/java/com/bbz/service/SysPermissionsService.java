package com.bbz.service;

import com.bbz.model.SysPermissions;

import java.util.List;

public interface SysPermissionsService {


    /**
     * 根据角色查询权限列表
     *
     * @param roleId
     * @return
     */
    List<SysPermissions> findSysPermissionsByRoleId(int roleId);
}
