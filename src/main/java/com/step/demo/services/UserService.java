package com.step.demo.services;

import com.step.demo.entities.User;
import com.step.demo.repositories.UserRepository;
import com.step.demo.specifications.UserSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Page<User> findUsersByFilterWithPaginate(Integer page, Integer limit, User user, List<Integer> roleIds) {
        return userRepository.findAll(new UserSpecs(user, roleIds), PageRequest.of(page, limit));
    }
}
