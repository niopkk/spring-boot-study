package com.bbz.service.impl;

import com.bbz.dao.SysPermissionsDao;
import com.bbz.model.SysPermissions;
import com.bbz.service.SysPermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysPermissionsServiceImpl implements SysPermissionsService {


    @Autowired
    private SysPermissionsDao sysPermissionsDao;

    @Override
    public List<SysPermissions> findSysPermissionsByRoleId(int roleId) {
        return sysPermissionsDao.findSysPermissionsByRoleId(roleId);
    }
}
