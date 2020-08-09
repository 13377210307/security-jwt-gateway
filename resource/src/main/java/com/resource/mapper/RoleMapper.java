package com.resource.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.model.entity.SysRole;

import java.util.List;

public interface RoleMapper extends BaseMapper<SysRole> {

    //根据用户id查询用户角色
    List<SysRole> getRolesByUserId(String userId);
}
