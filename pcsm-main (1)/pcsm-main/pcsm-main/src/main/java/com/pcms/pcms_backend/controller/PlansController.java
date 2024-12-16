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
@RequestMapping("/api/plan")
public class PlansController {

    @Autowired
    private PlanService planService;

    @PostMapping("/create")
    public ResponseEntity<Plans> createPlan(@RequestBody Plans plan) {
        Plans createdPlan = planService.createPlan(plan);
        return new ResponseEntity<>(createdPlan, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Plans> updatePlan(@PathVariable int id, @RequestBody Plans plan) {
        Plans updatedPlan = planService.updatePlan(id, plan);
        return new ResponseEntity<>(updatedPlan, HttpStatus.OK);
    }

    @GetMapping("/location/{location}")
    public ResponseEntity<List<Plans>> getPlansByLocation(@PathVariable String location) {
        List<Plans> plans = planService.getPlansByLocation(location);
        return new ResponseEntity<>(plans, HttpStatus.OK);
    }

    @GetMapping("/getAllPlans")
    public ResponseEntity<List<Plans>> getAllPlans() {
        System.out.println("Get all plans");
        List<Plans> plans = planService.getAllPlans();
        return new ResponseEntity<>(plans, HttpStatus.OK);
    }

    @PutMapping("/deletePlan/{id}")
    public ResponseEntity<Void> deletePlan(@PathVariable int id) {
        planService.deletePlan(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}