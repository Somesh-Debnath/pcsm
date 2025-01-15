package com.pcms.pcms_backend.repository;

import com.pcms.pcms_backend.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {
    List<Bill> findByUserPlanId(int userPlanId);
    List<Bill> findByBillAmountGreaterThan(double amount);
}