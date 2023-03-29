package com.example.hackcelerate.repositories;

import com.example.hackcelerate.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findUserByUsernameOrEmail(String username, String email);

    Optional<User> findByEmail(String email);

    Optional<User> findByEmailOrUsername(String email, String username);
}
