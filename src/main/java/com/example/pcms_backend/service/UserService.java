package com.example.pcms_backend.service;

import com.example.pcms_backend.entity.User;
import com.example.pcms_backend.exeception.UserAlreadyExistsException;
import com.example.pcms_backend.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(User user) {
        user.setApproved(false); // Default to not approved
        userRepository.save(user);
    }

    public void approveUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setApproved(true);
        userRepository.save(user);
    }

    public void rejectUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
    }
}
