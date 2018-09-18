package com.zzj.mapper;

import com.zzj.model.User;
import org.apache.ibatis.annotations.Mapper;

import javax.naming.Name;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByUserName(String email);
}