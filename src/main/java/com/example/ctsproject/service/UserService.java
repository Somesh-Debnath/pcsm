package com.example.pcms_backend.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pcms_backend.Entity.User;
import com.example.pcms_backend.UserRepository.UserRepository;
@Service
public class UserService {
   @Autowired
   private UserRepository userRepository;
   public User registerUser(User user) {
       user.setApproved(false); // Default to not approved
       return userRepository.save(user);
   }
   public User approveUser(Long id) {
       User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
       user.setApproved(true);
       return userRepository.save(user);
   }
   public User rejectUser(Long id) {
       User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
       userRepository.delete(user);
       return user;
   }
}
