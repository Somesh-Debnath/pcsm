package com.pcms.pcms_backend.service;


import com.pcms.pcms_backend.entity.Bill;
import com.pcms.pcms_backend.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    public Bill generateBill(int userPlanId, double usageAmount, double ratePerUnit) {
        double billAmount = usageAmount * ratePerUnit;
        Bill bill = new Bill();
        bill.setUserPlanId(userPlanId);
        bill.setBillAmount(billAmount);
        bill.setBillDate(new Date());
        return billRepository.save(bill);
    }

    public List<Bill> getBillsByUserPlanId(int userPlanId) {
        return billRepository.findByUserPlanId(userPlanId);
    }

    public List<Bill> getBillsAboveAmount(double amount) {
        return billRepository.findByBillAmountGreaterThan(amount);
    }
}
