package com.model.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class RoleMenu implements Serializable {

    private String roleId;

    private String menuId;
}
