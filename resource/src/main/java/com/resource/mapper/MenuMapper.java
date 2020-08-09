package com.resource.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.model.entity.SysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper extends BaseMapper<SysMenu> {

    List<String> getPermissionByUsername(@Param("username") String username);
}
