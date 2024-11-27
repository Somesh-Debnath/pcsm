package com.example.pcms_backend.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pcms_backend.Entity.User;
public interface UserRepository extends JpaRepository<User, Long> {
   User findByEmail(String email);
}