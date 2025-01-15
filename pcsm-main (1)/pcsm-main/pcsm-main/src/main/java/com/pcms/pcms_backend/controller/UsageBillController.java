package com.pcms.pcms_backend.controller;


import com.pcms.pcms_backend.entity.Bill;
import com.pcms.pcms_backend.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/usage-bill")
public class UsageBillController {

    @Autowired
    private BillService billService;

    @GetMapping("/{userId}")
    public List<Bill> getUsageAndBillDetails(@PathVariable int userId) {
        return billService.getBillsByUserPlanId(userId);
    }
}