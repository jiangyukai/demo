package com.zzj.service;

import com.zzj.model.User;

/**
 * @Auther: yk
 * @Date: 2018-8-15 16:03
 * @Description:
 */
public interface UserService {
    int addUser(User user);

    Object findAllUser(int pageNum, int pageSize);

    String encryptBasedDes(String data);

    String decryptBasedDes(String data);

    User findByUserName(String name);
}
