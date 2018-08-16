package com.zzj.service.impl;/**
 * @Auther: yk
 * @Date: 2018-8-15 16:04
 * @Description:
 */

import com.zzj.mapper.UserMapper;
import com.zzj.model.User;
import com.zzj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *@className UserServiceImpl
 *@Description TODO
 *@Author yk
 *@Date 2018-8-15 16:04
 *@Version 1.0
 **/
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
        User rs = userMapper.selectByPrimaryKey(1);
        return rs.toString().length();
    }

    @Override
    public Object findAllUser(int pageNum, int pageSize) {
        return null;
    }
}
