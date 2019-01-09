package com.zzj.service.impl;

import com.zzj.mapper.RolePermissionMapper;
import com.zzj.mapper.SysPermissionMapper;
import com.zzj.model.RolePermission;
import com.zzj.model.SysPermission;
import com.zzj.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @类名 SysPermissionServiceImpl
 * @描述 TODO
 * @作者 yk
 * @日期 2019-1-9 14:57
 **/
@Service
public class SysPermissionServiceImpl implements SysPermissionService {
    @Resource
    private RolePermissionMapper rolePermissionMapper;
    @Resource
    private SysPermissionMapper sysPermissionMapper;
    @Override
    public SysPermission getPermissionByRoleId(Integer id) {
        String sql = "select * from role_permission a where a.roleid="+id+"";
        RolePermission rolePermission = rolePermissionMapper.selectByRoleId(sql);
        SysPermission sysPermission =sysPermissionMapper.selectByPrimaryKey(rolePermission.getPermissionid());
        return sysPermission;
    }
}
