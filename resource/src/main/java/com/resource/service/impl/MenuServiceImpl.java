package com.resource.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.model.entity.SysMenu;
import com.resource.mapper.MenuMapper;
import com.resource.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, SysMenu> implements MenuService {


    @Override
    public List<String> getPermissionByUsername(String username) {
        return this.baseMapper.getPermissionByUsername(username);
    }
}
