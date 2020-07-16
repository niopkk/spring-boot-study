package com.bbz.dao;

import com.bbz.model.SysPermissions;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysPermissionsDao {

    /**
     * 根据角色查询权限列表
     *
     * @param roleId
     * @return
     */
    List<SysPermissions> findSysPermissionsByRoleId(int roleId);
}
