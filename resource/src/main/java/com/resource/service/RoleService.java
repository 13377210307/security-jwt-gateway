package com.resource.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.model.entity.SysRole;

import java.util.List;

public interface RoleService extends IService<SysRole> {

    // 根据用户id查询角色
    List<SysRole> getRolesByUserId(String userId);
}
