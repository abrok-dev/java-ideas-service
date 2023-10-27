package com.step.demo.entities;

public enum PermissionEnum {
    BASIC_READ("basic:read"),
    BASIC_WRITE("basic:write"),
    INITIATIVE_DRAFT("initiative:draft"),
    INITIATIVE_WAITING("initiative:waiting"),
    INITIATIVE_WORKING("initiative:working"),
    INITIATIVE_REWORKING("initiative:reworking"),
    INITIATIVE_CONFIRMED("initiative:confirmed"),
    INITIATIVE_CANCELED("initiative:canceled"),
    USER_CREATE("user:create"),
    USER_DELETE("user:delete");

    private final String name;
    PermissionEnum(String permission) {
        this.name = permission;
    }
}
