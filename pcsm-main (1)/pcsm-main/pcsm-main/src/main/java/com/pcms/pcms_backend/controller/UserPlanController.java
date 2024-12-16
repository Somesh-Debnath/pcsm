package com.pcms.pcms_backend.controller;

import com.pcms.pcms_backend.entity.UserPlans;
import com.pcms.pcms_backend.service.UserPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/user-plan")
public class UserPlanController {

    @Autowired
    private UserPlanService userPlanService;

    @PostMapping("/assign")
    public ResponseEntity<UserPlans> assignPlanToUser(@RequestBody UserPlans userPlan) {
        UserPlans assignedPlan = userPlanService.assignPlanToUser(userPlan);
        return new ResponseEntity<>(assignedPlan, HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<UserPlans>> getUserPlans() {
        List<UserPlans> userPlans = userPlanService.getUserPlans();
        return new ResponseEntity<>(userPlans, HttpStatus.OK);
    }

    @PutMapping("/update-status/{id}")
    public ResponseEntity<UserPlans> updateStatus(@PathVariable int id, @RequestBody UserPlans userPlan) {
        userPlanService.updateStatusToApproved(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<Void> deletePlan(@PathVariable int id) {
        userPlanService.deletePlan(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}