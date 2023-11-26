package com.step.demo.entities;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.core.GrantedAuthority;

import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name = "roles")
public class Role {

    @Column(name = "permissions", length = 3000)
    private String permissions;
    @Transient
    private Set<GrantedAuthority> permissionsSet = null;
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "created_at")
    @CreatedDate
    private Date createdAt;

//    @ManyToMany(targetEntity = User.class, mappedBy = "users", fetch = FetchType.LAZY)
//    @JoinTable(
//            name = "users_roles",
//            joinColumns = @JoinColumn(name = "role_id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id")
//    )
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Set<User> users = new HashSet<>();

    public Role() {

    }
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Set<GrantedAuthority> getPermissionsSet() {
        if (permissionsSet == null && permissions != null && !permissions.isEmpty()) {
            permissionsSet = Arrays.stream(permissions.split(","))
                    .map((value -> (GrantedAuthority)new Permission(value)))
                    .collect(Collectors.toSet());
        }
        return permissionsSet;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Role role)) {
            return false;
        }

        return role.name.equals(this.name)
                && role.getPermissionsSet().equals(this.getPermissionsSet());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "Role: " + name;
    }
}
