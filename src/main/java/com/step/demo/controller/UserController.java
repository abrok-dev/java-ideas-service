package com.step.demo.controller;

import com.step.demo.dto.UserDto;
import com.step.demo.entities.User;
import com.step.demo.mappers.UserMapper;
import com.step.demo.services.UserService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping(value = "/")
    public Page<UserDto> findUsers(
            @RequestParam(value = "page", defaultValue = "0") @Min(0) @Max(100_000_000) Integer page,
            @RequestParam(value = "limit", defaultValue = "100") @Min(1) @Max(250) Integer limit,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "username",  required = false) String username,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "secondName", required = false) String secondName,
            @RequestParam(value = "surname", required = false) String surname,
            @RequestParam(value = "roleIds", required = false) List<Integer> roleIds
    ) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setName(name);
        user.setSurname(surname);
        user.setSecondName(secondName);

        Page<User> users = service.findUsersByFilterWithPaginate(page, limit, user, roleIds);

        return users.map(UserMapper::toDto);
    }
}
