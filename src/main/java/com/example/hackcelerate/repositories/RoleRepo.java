package com.example.hackcelerate.repositories;

import com.example.hackcelerate.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findRoleByName(String name);
}

