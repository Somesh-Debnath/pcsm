package com.example.pcms_backend.controller;

import com.example.pcms_backend.entity.User;
import com.example.pcms_backend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully! Await admin approval.");
    }

    @PostMapping("/approve/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> approveUser(@PathVariable Long id) {
        userService.approveUser(id);
        return ResponseEntity.ok("User approved successfully!");
    }

    @PostMapping("/reject/{id}")
    public ResponseEntity<String> rejectUser(@PathVariable Long id) {
        userService.rejectUser(id);
        return ResponseEntity.ok("User rejected successfully!");
    }
}