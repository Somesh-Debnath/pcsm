package com.pcms.UserPlans.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pcms.UserPlans.Model.Plans;
import com.pcms.UserPlans.Service.PlanService;

@RestController
@RequestMapping("/plan")
public class PlansController {

	@Autowired
	private PlanService planService;
	
	@PostMapping("/addPlan")
	public ResponseEntity<Plans> createPlans(@RequestBody Plans plans) {
		Plans plans2 = planService.addPlans(plans);
		return new ResponseEntity<Plans>(plans2, HttpStatus.OK);
	}
	@GetMapping("/getPlan/{planId}")
	   public ResponseEntity<Plans> getPlanById(@PathVariable Long planId) {
	       Plans plan = planService.getPlanById(planId);
	       if (plan != null) {
	           return new ResponseEntity<>(plan, HttpStatus.OK);
	       } else {
	           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	       }
	   }
	 @PutMapping("/updatePlan/{planId}")
	   public ResponseEntity<Plans> updatePlan(
	           @PathVariable Long planId,
	           @RequestBody Plans updatedPlan) {
	       Plans updated = planService.updatePlan(planId, updatedPlan);
	       if (updated != null) {
	           return new ResponseEntity<>(updated, HttpStatus.OK);
	       } else {
	           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	       }
	   }
	   @GetMapping("/getAllPlans")
	   public ResponseEntity<List<Plans>> getAllPlans() {
	       return new ResponseEntity<>(planService.getAllPlans(), HttpStatus.OK);
	   }
	   @DeleteMapping("/deletePlan/{planId}")
	   public ResponseEntity<Void> deletePlanById(@PathVariable Long planId) {
	       planService.deletePlanById(planId);
	       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	   }
}
