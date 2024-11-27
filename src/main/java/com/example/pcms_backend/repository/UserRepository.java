package com.example.pcms_backend.repository;

import com.example.pcms_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

   boolean existsByEmail(String email);

   boolean existsByPhoneNumber(String phoneNumber);
}