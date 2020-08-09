package com.resource.controller;

import com.resource.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private MenuService menuService;

    @PostMapping("getPermissionByUsername")
    public List<String> getPermissionByUsername(@RequestParam("username") String username) {
        return this.menuService.getPermissionByUsername(username);
    }
}
