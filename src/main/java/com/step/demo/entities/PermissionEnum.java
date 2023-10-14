package com.step.demo.entities;

public enum PermissionEnum {
    BASIC_READ("basic:read"),
    BASIC_WRITE("basic:write");

    private final String permission;
    PermissionEnum(String permission) {
        this.permission = permission;
    }
}
