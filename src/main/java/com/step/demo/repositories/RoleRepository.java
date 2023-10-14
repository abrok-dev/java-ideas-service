package com.step.demo.repositories;

import com.step.demo.entities.Role;
import com.step.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);

}
