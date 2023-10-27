package com.step.demo.commands;

import com.step.demo.entities.PermissionEnum;
import com.step.demo.entities.Role;
import com.step.demo.entities.User;
import com.step.demo.repositories.RoleRepository;
import com.step.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.transaction.annotation.Transactional;

@ShellComponent
public class DatabaseSeeder {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @ShellMethod(value = "db-seed")
    @Transactional
    public String seed(@ShellOption(defaultValue = "all") String arg) {
        Role brandRole = new Role();
        String brandPermissions = String.valueOf(PermissionEnum.INITIATIVE_CONFIRMED) + ',' +
                PermissionEnum.INITIATIVE_WAITING + ',' +
                PermissionEnum.INITIATIVE_WORKING + ',' +
                PermissionEnum.INITIATIVE_REWORKING;
        brandRole.setPermissions(brandPermissions);
        brandRole.setName("Brand manager");

        Role authorRole = new Role();
        String authorPermissions = String.valueOf(PermissionEnum.INITIATIVE_DRAFT) + ',' +
                PermissionEnum.INITIATIVE_WAITING + ',' +
                PermissionEnum.INITIATIVE_WORKING + ',' +
                PermissionEnum.INITIATIVE_REWORKING + ',' +
                PermissionEnum.INITIATIVE_CANCELED;

        authorRole.setName("Author");
        authorRole.setPermissions(authorPermissions);

        User admin = new User();
        admin.setVerifiedEmail(true);
        admin.setEmail("abrok-super@mail.ru");
        admin.setUsername("admin");
        admin.setName("Rostislav");
        admin.setSurname("Chevakin");
        admin.setSecondName("Ivanovich");

        String password = passwordEncoder.encode("admin");
        admin.setPassword(password);

        User author = new User();
        author.setUsername("Author");
        author.setSurname("Semenov");
        author.setName("Semen");
        author.setSecondName("Semenovich");
        author.setPassword(passwordEncoder.encode("semen"));
        author.setEmail("chevakin-rostislav@mail.ru");
        author.setVerifiedEmail(true);

        User manager = new User();
        manager.setSurname("Managerov");
        manager.setName("Van");
        manager.setSecondName("Semenov");
        manager.setEmail("abrok3@yandex.ru");
        manager.setVerifiedEmail(true);
        manager.setPassword(passwordEncoder.encode("manager"));
        manager.setUsername("manager");

        authorRole = roleRepository.save(authorRole);
        brandRole = roleRepository.save(brandRole);

        manager.addRole(brandRole);
        manager.addRole(authorRole);
        admin.addRole(authorRole);
        admin.addRole(brandRole);
        author.addRole(authorRole);
        userRepository.save(admin);
        userRepository.save(manager);
        userRepository.save(author);

        return "success";
    }
}
