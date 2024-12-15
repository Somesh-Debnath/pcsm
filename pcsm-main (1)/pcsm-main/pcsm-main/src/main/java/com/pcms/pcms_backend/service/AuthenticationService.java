package com.pcms.pcms_backend.service;

import com.pcms.pcms_backend.entity.User;
import com.pcms.pcms_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean authenticate(String fullName, String rawPassword) {
        // Fetch the user directly
        User user = userRepository.findByFullName(fullName);
        // Check if the user exists and validate the password
        if (user != null) {
            return passwordEncoder.matches(rawPassword, user.getPassword());
        }
        return false; // Return false if user not found
    }
}