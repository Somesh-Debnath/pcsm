package com.pcms.pcms_backend.repository;

import com.pcms.pcms_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByStatus(String status);

    User findByEmail(String email);
}