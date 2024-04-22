package com.enrollzambia.todoapp.todoappapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enrollzambia.todoapp.todoappapi.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

  boolean existsByUsername(String username);

  User findByUsername(String username);
}