package com.resource.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.model.entity.SysRole;
import com.resource.mapper.RoleMapper;
import com.resource.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, SysRole> implements RoleService {

    /**
     * 根据用户id查询角色
     */
    @Override
    public List<SysRole> getRolesByUserId(String userId) {
        return this.baseMapper.getRolesByUserId(userId);
    }
}
