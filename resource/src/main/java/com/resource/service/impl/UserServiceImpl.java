package com.resource.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.model.entity.SysUser;
import com.resource.mapper.UserMapper;
import com.resource.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, SysUser> implements UserService {


    /**
     * 根据用户名查询用户信息
     */
    @Override
    public SysUser loadUserByUsername(String username) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        return this.baseMapper.selectOne(queryWrapper);
    }
}
