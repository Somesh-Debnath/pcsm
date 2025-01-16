package com.pcms.pcms_backend.repository;

import com.pcms.pcms_backend.entity.UsageBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UsageBillRepository extends JpaRepository<UsageBill, Integer> {
    List<UsageBill> findByUserPlans_UserPlanId(int userPlanId);
    List<UsageBill> findByBillAmountGreaterThan(double amount);
    List<UsageBill> findByUsageDateBetween(Date from, Date to);
}