package com.pcms.pcms_backend.service;

import com.pcms.pcms_backend.entity.User;
import com.pcms.pcms_backend.entity.UserPlans;
import com.pcms.pcms_backend.repository.UserPlanRepository;
import com.pcms.pcms_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserPlanService {

    @Autowired
    private UserPlanRepository userPlanRepository;

    @Autowired
    private UserRepository userRepository;

    public UserPlans assignPlanToUser(UserPlans userPlan) {

            return userPlanRepository.save(userPlan);
        
    }

    public List<UserPlans> getUserPlans() {
        return userPlanRepository.findAll();
    }

    public void updateStatusToApproved(int userPlanId) {
        Optional<UserPlans> existingUserPlan = userPlanRepository.findById(userPlanId);
        if (existingUserPlan.isPresent()) {
            UserPlans userPlan = existingUserPlan.get();
           userPlan.setStatus("APPROVED");
            userPlanRepository.save(userPlan);
        } else {
            throw new IllegalArgumentException("User plan not found");
        }
    }

    public void deletePlan(int id) {
        userPlanRepository.deleteById(id);
    }
}