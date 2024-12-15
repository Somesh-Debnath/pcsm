package com.pcms.UserPlans.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcms.UserPlans.Model.Plans;
import com.pcms.UserPlans.Repository.UserPlanRepository;

@Service
public class PlanService {
	@Autowired
	private UserPlanRepository userPlanRepository;
	
	public Plans addPlans(Plans plans) {
		return userPlanRepository.save(plans);
	}
	public Plans getPlanById(Long planId) {
	       return userPlanRepository.findById(planId).orElse(null);
	   }
	   public List<Plans> getAllPlans() {
	       return userPlanRepository.findAll();
	   }
	   
	   public void deletePlanById(Long planId) {
		   userPlanRepository.deleteById(planId);
	   }
	   public Plans updatePlan(Long planId, Plans updatedPlan) {
	       Optional<Plans> optionalPlan = userPlanRepository.findById(planId);
	       if (optionalPlan.isPresent()) {
	           Plans existingPlan = optionalPlan.get();
	           existingPlan.setPlan_Name(updatedPlan.getPlanName());
	           existingPlan.setLocation(updatedPlan.getLocation());
	           existingPlan.setPrice(updatedPlan.getPrice());
	           return userPlanRepository.save(existingPlan);
	       } else {
	           return null; // Handle not found
	       }
	   }
}
