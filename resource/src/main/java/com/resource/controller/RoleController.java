package com.resource.controller;

import com.model.entity.SysRole;
import com.resource.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/getRolesByUserId")
    public List<SysRole> getRolesByUserId(@RequestParam("userId") String userId) {
        return this.roleService.getRolesByUserId(userId);
    }
}
