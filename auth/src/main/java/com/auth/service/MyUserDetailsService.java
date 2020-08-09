package com.auth.service;

import com.auth.clients.ResourceClient;
import com.model.entity.SysRole;
import com.model.entity.SysUser;
import common.constant.ExceptionConstant;
import common.exceptions.CustomException;
import io.jsonwebtoken.lang.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private ResourceClient resourceClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 根据用户名获取用户信息
        SysUser sysUser = this.resourceClient.loadUserByUsername(username);
        if (sysUser == null) {
            try {
                throw new CustomException(ExceptionConstant.NOT_EXIT,"用户不存在");
            } catch (CustomException e) {
                e.printStackTrace();
            }
        }

        /*SysUser sysUser = new SysUser();
        sysUser.setId("1");
        sysUser.setUsername("admin");
        sysUser.setPassword("$2a$10$lylynh4X75lHuYbc1Al1lu6fcEktFZUAAEMkYqa7v3K.NH8NkwLIK");*/

        // 根据用户id查询用户角色
        List<SysRole> roles = this.resourceClient.getRolesByUserId(sysUser.getId());
        System.out.println(roles);
        String roleKey = "";
        if (!CollectionUtils.isEmpty(roles)) {
            roleKey = roles.stream().map(SysRole::getKey).collect(Collectors.joining(","));
        }
        return new User(username,sysUser.getPassword(),true,true,true,true, AuthorityUtils.commaSeparatedStringToAuthorityList(roleKey));
    }
}
