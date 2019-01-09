package com.zzj.service;

import com.zzj.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getRoleByUserId(Integer id);
}
