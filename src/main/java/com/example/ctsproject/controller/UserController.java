package com.example.pcms_backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.pcms_backend.Entity.User;
import com.example.pcms_backend.UserService.UserService;
@RestController
@RequestMapping("/api/users")
public class UserController {
   @Autowired
   private UserService userService;
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