package com.resource.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.model.entity.SysMenu;

import java.util.List;

public interface MenuService extends IService<SysMenu> {


    List<String> getPermissionByUsername(String username);
}
