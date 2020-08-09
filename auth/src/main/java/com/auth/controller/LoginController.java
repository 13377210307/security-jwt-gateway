package com.auth.controller;

import com.auth.config.JwtAuthConfig;
import com.model.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private JwtAuthConfig jwtAuthConfig;

    @PostMapping
    public String login(@RequestBody SysUser sysUser, HttpServletResponse response) {
        return this.jwtAuthConfig.login(sysUser,response);
    }

    @GetMapping("admin")
    public String admin() {
        return "超管访问";
    }

    @GetMapping("user")
    public String user() {
        return "普通用户访问";
    }
}
