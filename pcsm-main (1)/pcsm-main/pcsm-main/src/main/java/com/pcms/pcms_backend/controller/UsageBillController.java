package com.pcms.pcms_backend.controller;

import com.pcms.pcms_backend.dto.BillRequestDTO;
import com.pcms.pcms_backend.entity.UsageBill;
import com.pcms.pcms_backend.service.UsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/usage-bill")
public class UsageBillController {

    @Autowired
    private UsageService usageService;

@PostMapping("/calculate")
public UsageBill calculateAndStoreBill(@RequestBody BillRequestDTO billRequest) {
  return usageService.calculateAndStoreBill(billRequest.getUserPlanId(), billRequest.getFrom(), billRequest.getTo());

}
//    @GetMapping("/breakdown/{userPlanId}")
//    public List<UsageBill> getBillBreakdown(@PathVariable int userPlanId) {
//        return usageService.getBillBreakdown(userPlanId);
//    }

@GetMapping("/{userPlanId}")
public double getCumulativeBill(@PathVariable int userPlanId) {
    return usageService.getCumulativeBill(userPlanId);
}
}