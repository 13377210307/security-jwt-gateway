package com.model.remotes;

import com.model.entity.SysRole;
import com.model.entity.SysUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ResourceRemote {

    @PostMapping("/permission/getPermissionByUsername")
    List<String> getPermissionByUsername(@RequestParam("username") String username) ;

    @PostMapping("/role/getRolesByUserId")
    List<SysRole> getRolesByUserId(@RequestParam("userId") String userId);

    @PostMapping("/user/loadUserByUsername")
    SysUser loadUserByUsername(@RequestParam("username") String username);
}
