package com.pcms.pcms_backend.service;

import com.pcms.pcms_backend.entity.Plans;
import com.pcms.pcms_backend.repository.PlansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanService {

    @Autowired
    private PlansRepository plansRepository;

    public Plans createPlan(Plans plan) {
        return plansRepository.save(plan);
    }

    public Plans updatePlan(int planId, Plans updatedPlan) {
        Optional<Plans> existingPlan = plansRepository.findById(planId);
        if (existingPlan.isPresent()) {
            Plans plan = existingPlan.get();
            plan.setPlanName(updatedPlan.getPlanName());
            plan.setLocation(updatedPlan.getLocation());
            plan.setPrice(updatedPlan.getPrice());
            plan.setDescription(updatedPlan.getDescription());
            return plansRepository.save(plan);
        } else {
            throw new IllegalArgumentException("Plan not found");
        }
    }

    public List<Plans> getPlansByLocation(String location) {
        return plansRepository.findByLocation(location);
    }

    public void deletePlan(int planId) {
        plansRepository.deleteById(planId);
    }

    public List<Plans> getAllPlans() {
        return plansRepository.findAll();
    }
}