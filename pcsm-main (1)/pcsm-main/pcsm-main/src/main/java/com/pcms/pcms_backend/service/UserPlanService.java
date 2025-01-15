package com.pcms.pcms_backend.service;

import com.pcms.pcms_backend.entity.UserPlans;
import com.pcms.pcms_backend.repository.UserPlanRepository;
import com.pcms.pcms_backend.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
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

    public void updateStatus(int userPlanId, String status) {
    Optional<UserPlans> existingUserPlan = userPlanRepository.findById(userPlanId);
        log.info("existingUserPlan: {}", status);
    if (existingUserPlan.isPresent()) {
        UserPlans userPlan = existingUserPlan.get();
        if ("APPROVED".equalsIgnoreCase(status)) {
            userPlan.setStatus(status.toUpperCase());
            userPlanRepository.save(userPlan);
        } else if ("REJECTED".equalsIgnoreCase(status)) {
            userPlanRepository.delete(userPlan);
        } else {
            throw new IllegalArgumentException("Invalid status");
        }
    } else {
        throw new IllegalArgumentException("User plan not found");
    }
}

    public void deletePlan(int id) {
        userPlanRepository.deleteById(id);
    }
}