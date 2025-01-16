package com.pcms.pcms_backend.service;

import com.pcms.pcms_backend.entity.UsageBill;
import com.pcms.pcms_backend.entity.UserPlans;
import com.pcms.pcms_backend.repository.UsageBillRepository;
import com.pcms.pcms_backend.repository.UserPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UsageService {

    @Autowired
    private UsageBillRepository usageBillRepository;

    @Autowired
    private UserPlanRepository userPlansRepository;

    public UsageBill calculateAndStoreBill(int userPlanId, Date from, Date to) {
        UserPlans userPlan = userPlansRepository.findById(userPlanId).orElseThrow(() -> new IllegalArgumentException("Invalid userPlanId"));
        double ratePerUnit = userPlan.getPrice();
        long days = (to.getTime() - from.getTime()) / (1000 * 60 * 60 * 24);
        double billAmount = ratePerUnit * days;

        UsageBill usageBill = new UsageBill();
        usageBill.setUserPlans(userPlan);
        usageBill.setUsageAmount((int) days);
        usageBill.setBillAmount(billAmount);
        usageBill.setUsageDate(new Date());

        usageBillRepository.save(usageBill);
        return usageBill;
    }

    public List<UsageBill> getBillBreakdown(int userPlanId) {
        return usageBillRepository.findByUserPlans_UserPlanId(userPlanId);
    }

    public double getCumulativeBill(int userPlanId) {
        List<UsageBill> usageBills = usageBillRepository.findByUserPlans_UserPlanId(userPlanId);
        return usageBills.stream().mapToDouble(UsageBill::getBillAmount).sum();
    }
}