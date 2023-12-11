package com.step.demo.entities;

import org.springframework.security.core.GrantedAuthority;

import java.util.Objects;

public class Permission implements GrantedAuthority  {
    private final String name;

     public Permission(String permission) {
        this.name = permission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Permission that = (Permission) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String getAuthority() {
        return name;
    }

    @Override
    public String toString() {
        return "Permission:" + name;
    }
}
