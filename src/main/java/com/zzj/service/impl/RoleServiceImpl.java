package com.zzj.service.impl;

import com.zzj.mapper.RoleMapper;
import com.zzj.mapper.UserRoleMapper;
import com.zzj.model.Role;
import com.zzj.model.UserRole;
import com.zzj.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @类名 RoleServiceImpl
 * @描述 TODO
 * @作者 yk
 * @日期 2019-1-9 14:53
 **/
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;//autowired必须在mapper接口处使用@mapper和@Repository注解，否则报错，但是不影响运行，因为整体都

    @Override
    public List<Role> getRoleByUserId(Integer id) {
        String sql = "select * from user_role a where a.userid="+id+"";
        List<Role> roleList= new ArrayList<>();
        List<UserRole> userRoleList = userRoleMapper.selectByUserId(sql);

        for (UserRole userRole : userRoleList) {
            String sql1 = "select * from sysrole a where a.id ="+userRole.getRoleid()+"";
            roleList  = roleMapper.selectByRoleId(sql1);
        }
        return roleList;
    }
}
