package com.step.demo.mappers;

import com.step.demo.dto.UserDto;
import com.step.demo.entities.Role;
import com.step.demo.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;

@Component
public class UserMapper {

    private UserMapper(){}
    public static UserDto toDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setName(user.getName());
        dto.setSurname(user.getSurname());
        dto.setSecondName(user.getSecondName());
        dto.setRoleNames(user.getRoles().stream().map(Role::getName).toList());

        Collection<String> permissions = user.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();

        dto.setPermissions(String.join(",", permissions));

        return dto;
    }
}
