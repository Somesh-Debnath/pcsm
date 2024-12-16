package com.pcms.pcms_backend.service;

import com.pcms.pcms_backend.entity.UserPlans;
import com.pcms.pcms_backend.repository.UserPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AutoTerminationService {

    @Autowired
    private UserPlanRepository userPlanRepository;

    public void checkAndAutoTerminate() {
        List<UserPlans> userPlans = userPlanRepository.findByAutoTerminatedFalse();
        LocalDate currentDate = LocalDate.now();
        for (UserPlans userPlan : userPlans) {
            if (LocalDate.parse(userPlan.getRequiredTo()).isBefore(currentDate)) {
                userPlan.setAutoTerminated(true);
                userPlanRepository.save(userPlan);
            }
        }
    }
}