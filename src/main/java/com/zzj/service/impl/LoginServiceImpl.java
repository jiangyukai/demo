package com.zzj.service.impl;

import com.zzj.mapper.UserMapper;
import com.zzj.model.User;
import com.zzj.service.LoginService;
import com.zzj.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @类名 LoginServiceImpl
 * @描述 TODO
 * @作者 yk
 * @日期 2018-9-12 15:16
 **/
@Service(value = "loginService")
public class LoginServiceImpl implements LoginService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserService userService;

    @Override
    public Map<String, Object> stratLogin(HashMap<String, Object> paramMap) {
        String username = paramMap.get("username")+"";
        String password = paramMap.get("password")+"";
        Map<String,Object> rsMap = new HashMap<>();
        //用户验证操作**********************开始
        User rsuser = userMapper.selectByUserName(username);
        if(null == rsuser){
            rsMap.put("success",true);
            rsMap.put("msg","用户不存在！");
            return rsMap;
        }
        String rspassword = rsuser.getPassword();
        String realpass = userService.decryptBasedDes(rspassword);
        if(!password.equals(realpass)){
            rsMap.put("success",true);
            rsMap.put("msg","密码校验错误！");
            return rsMap;
        }

        //用户验证操作**********************结束
        rsMap.put("success",true);
        rsMap.put("msg","登录成功！");
        return rsMap;
    }
}
