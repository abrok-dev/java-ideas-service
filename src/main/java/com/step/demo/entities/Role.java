package com.step.demo.entities;

import com.step.demo.dto.RulesDTO;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.core.GrantedAuthority;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "roles")
public class Role {

    @Column(name = "permissions", length = 3000)
    private String permissions;

    public Role() {

    }

    @Transient
    private Set<GrantedAuthority> permissionsSet = null;

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name= "name")
    private String name;

    @Column(name = "created_at")
    @CreatedDate
    private Date createdAt;

    @ManyToMany(targetEntity = User.class, mappedBy = "users", fetch = FetchType.LAZY)
    private HashSet<User> users;

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
}
