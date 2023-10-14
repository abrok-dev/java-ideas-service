package com.step.demo.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name="username", unique = true)
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="email", unique = true)
    private String email;

    @Column(name="verified_email")
    private boolean verifiedEmail;
    @Column(name = "created_at")
    private Date createdAt;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;
    @Transient
    private String passwordConfirm;
    @Transient
    private Set<Permission> authorities;
    @Column(name = "surname")
    private String surname;
    @Column(name = "name")
    private String name;
    @Column(name = "second_name")
    private String secondName;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (authorities == null) {
            Set<GrantedAuthority> permissions = new HashSet<>();
            var roles = getRoles();
            for (Role role: roles) {
                permissions.addAll(role.getPermissionsSet());
            }
            return permissions;
        }
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public boolean isVerifiedEmail() {
        return verifiedEmail;
    }

    public void setVerifiedEmail(boolean verifiedEmail) {
        this.verifiedEmail = verifiedEmail;
    }
}
