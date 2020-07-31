package com.ronz.domain;

import java.io.Serializable;

/**
 * @program: punchsystem
 * @author: Ronz
 * @create: 2020-06-07 11:04
 **/
public class Role implements Serializable {

    private Integer roleId;
    private String roleName;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
