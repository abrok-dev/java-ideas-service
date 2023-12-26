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
    USER_DELETE("user:delete"),
    BRAND_ATTRIBUTE_INDEX("brand_attribute:index"),
    BRAND_ATTRIBUTE_SAVE("brand_attribute:save"),
    BRAND_ATTRIBUTE_DELETE("brand_attribute:delete"),
    TARGET_AUDIENCE_INDEX("target_audience:index"),
    TARGET_AUDIENCE_DELETE("target_audience:delete"),
    TARGET_AUDIENCE_SAVE("target_audience:save");

    public String getName() {
        return name;
    }

    private final String name;
    PermissionEnum(String permission) {
        this.name = permission;
    }
}
