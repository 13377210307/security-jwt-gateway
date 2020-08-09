package com.resource.controller;

import com.model.entity.SysUser;
import com.resource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/loadUserByUsername")
    public SysUser loadUserByUsername(@RequestParam("username") String username) {
        return this.userService.loadUserByUsername(username);
    }
}
