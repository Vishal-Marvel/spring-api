package com.example.hackcelerate;

import com.example.hackcelerate.model.Role;
import com.example.hackcelerate.model.User;
import com.example.hackcelerate.repositories.RoleRepo;
import com.example.hackcelerate.repositories.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Set;

//@Component
public class Bootstrap implements CommandLineRunner {
    private final RoleRepo roleRepo;
    private final UserRepo  userRepo;
    private final PasswordEncoder passwordEncoder;

    public Bootstrap(RoleRepo roleRepo, UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.roleRepo = roleRepo;
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        Role user = new Role(1L, "ROLE_USER");
        Role admin = new Role(2L, "ROLE_ADMIN");
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(user);
        roles.add(admin);
        roleRepo.saveAll(roles);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User admin_user = new User(1L, "Admin", "admin@gmail.com", "admin", passwordEncoder.encode("password"), Set.of(admin, user));
        userRepo.save(admin_user);


    }
}
