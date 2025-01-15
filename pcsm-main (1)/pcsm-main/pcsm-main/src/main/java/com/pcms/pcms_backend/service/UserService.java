package com.pcms.pcms_backend.service;

import com.pcms.pcms_backend.dto.UserDTO;
import com.pcms.pcms_backend.entity.User;
import com.pcms.pcms_backend.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final List<User> pendingUsers = new ArrayList<>();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public List<User> getNewlyRegisteredUsers() {
        return userRepository.findByStatus("NEW");
    }

    public void updateUserStatus(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setStatus(userDTO.getStatus());
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String email) {
        return userRepository.findByEmail(email);
    }
}