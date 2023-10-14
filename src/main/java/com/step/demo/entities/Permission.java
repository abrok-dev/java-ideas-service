package com.step.demo.entities;

import org.springframework.security.core.GrantedAuthority;

public class Permission implements GrantedAuthority {
    private final String permission;

     public Permission(String permission) {
        this.permission = permission;
    }

    @Override
    public String getAuthority() {
        return permission;
    }
}
