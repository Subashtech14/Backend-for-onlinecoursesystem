package com.chatting.demo.repository;

import com.chatting.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    User findByUsernameAndPassword(String username, String password);
}

