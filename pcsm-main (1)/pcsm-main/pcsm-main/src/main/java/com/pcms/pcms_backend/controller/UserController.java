package com.pcms.pcms_backend.controller;

import com.pcms.pcms_backend.dto.UserDTO;
import com.pcms.pcms_backend.entity.User;
import com.pcms.pcms_backend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        userService.saveUser(user);
        return ResponseEntity.ok("User registration request received! Await admin approval.");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUserStatus(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        userService.updateUserStatus(id, userDTO);
        return ResponseEntity.ok("User status updated successfully!");
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/getUser/{email}")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<User> getUserById(@PathVariable String email) {
        User user = userService.getUserById(email);
        return ResponseEntity.ok(user);
    }
}