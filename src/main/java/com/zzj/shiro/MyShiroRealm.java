package com.zzj.shiro;

import com.zzj.model.Role;
import com.zzj.model.SysPermission;
import com.zzj.model.User;
import com.zzj.service.RoleService;
import com.zzj.service.SysPermissionService;
import com.zzj.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @类名 MyShiroRealm
 * @描述 实现接口，完成用户认证
 * @作者 yk
 * @日期 2019-1-9 14:20
 **/
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;
    @Autowired
    private SysPermissionService sysPermissionService;

    /**
     * @名称 doGetAuthorizationInfo
     * @描述 //角色权限和对应权限添加
     * @参数 [principalCollection]
     * @返回值 org.apache.shiro.authz.AuthorizationInfo
     * @作者 yk
     * @时间 2019-1-9 14:25
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录用户名
        String name = (String) principalCollection.getPrimaryPrincipal();
        //查询用户名称
        User user = userService.findByUserName(name);
        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //查询用户角色
        List<Role> roleList = roleService.getRoleByUserId(user.getId());

        //查询用户权限
        for (Role role :roleList){
            simpleAuthorizationInfo.addRole(role.getRole());
            SysPermission sysPermission = sysPermissionService.getPermissionByRoleId(role.getId());
            simpleAuthorizationInfo.addStringPermission(sysPermission.getPermission());
        }
        return simpleAuthorizationInfo;
    }

    /**
     * @名称 doGetAuthenticationInfo
     * @描述 //用户认证
     * @参数 [authenticationToken]
     * @返回值 org.apache.shiro.authc.AuthenticationInfo
     * @作者 yk
     * @时间 2019-1-9 14:26
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //加这一步的目的是在Post请求的时候会先进认证，然后在到请求
        if (authenticationToken.getPrincipal() == null) {
            return null;
        }
        //获取用户信息
        String name = authenticationToken.getPrincipal().toString();

        //查询用户名称
        User user = userService.findByUserName(name);
        if (user == null) {
            //这里返回后会报出对应异常
            return null;
        } else {
            //这里验证authenticationToken和simpleAuthenticationInfo的信息
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(name, user.getPassword().toString(), getName());
            return simpleAuthenticationInfo;
        }

    }
}
