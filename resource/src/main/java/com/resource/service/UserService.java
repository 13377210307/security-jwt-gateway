package com.resource.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.model.entity.SysUser;

public interface UserService extends IService<SysUser> {

    // 根据用户名查询用户信息
    SysUser loadUserByUsername(String username);
}
