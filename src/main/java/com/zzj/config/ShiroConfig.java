package com.zzj.config;


import com.zzj.shiro.MyShiroRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * @类名 ShiroConfig
 * @描述
 * @作者 yk
 * @日期 2019-1-9 14:03
 **/
@Configuration
public class ShiroConfig {
    //将自己的验证方式加入容器
    @Bean
    public MyShiroRealm myShiroRealm(){
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        return myShiroRealm;
    }


    //权限管理，配置主要是Realm的管理认证
    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        return securityManager;
    }

    //配置filter ,设置对应的过滤条件和跳转条件
    /* Shiro 内置过滤器，可以实现权限相关的拦截器
     *  常用的过滤器：
     *      anon:无需认证（登录）可以访问
     *      authc:必须认证才可以访问
     *      user:如果使用rememberMe的功能可以直接访问
     *      perms:该资源必须得到资源权限才可以访问
     *      role:该资源必须得到角色的权限才可以访问
     */
    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager){
        System.out.println("shiro filter start=================================");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String,String> map = new LinkedHashMap<>();
        //配置不被拦截的路径(这个map需要是linkMap,同时如果只配置static目录是不行的，因为Springboot默认的将静态资源全部分配到static目录下，所以还需要配置他们下面的目录层级)
        map.put("/static/**", "anon");
        map.put("/js/**", "anon");
        map.put("/image/**", "anon");
        map.put("/css/**", "anon");
        map.put("/bootstrop/**", "anon");
        map.put("/layer/**", "anon");
        map.put("/layui/**", "anon");
        map.put("/register.html", "anon");
        //登出
        map.put("/logout","logout");
        //对所有用户认证
        map.put("/**","authc");
        //登录
        shiroFilterFactoryBean.setLoginUrl("/login/userLogin");
        //首页
        shiroFilterFactoryBean.setSuccessUrl("/login/startLogin");
        //错误页面，认证不通过跳转
        shiroFilterFactoryBean.setUnauthorizedUrl("/error");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;

    }

    //加入注解的使用，不加入这个注解不生效
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
