package com.pcms.pcms_backend.controller;


import com.pcms.pcms_backend.entity.Plans;
import com.pcms.pcms_backend.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/plans")
public class PlansController {

    private final PlanService planService;

    public PlansController(PlanService planService) {
        this.planService = planService;
    }

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
