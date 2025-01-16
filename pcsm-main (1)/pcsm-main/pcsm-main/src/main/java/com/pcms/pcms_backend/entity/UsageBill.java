package com.pcms.pcms_backend.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class UsageBill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer usageBillId;

    @Column(nullable = false)
    private Integer usageAmount;

    @Column(nullable = false)
    private double billAmount;

    @Temporal(TemporalType.DATE)
    private Date usageDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userPlanId")
    private UserPlans userPlans;

    // Getters and setters

    public Integer getUsageBillId() {
        return usageBillId;
    }

    public void setUsageBillId(Integer usageBillId) {
        this.usageBillId = usageBillId;
    }

    public Integer getUsageAmount() {
        return usageAmount;
    }

    public void setUsageAmount(Integer usageAmount) {
        if (usageAmount < 0) {
            throw new IllegalArgumentException("UsageAmount should be greater than or equal to 0");
        }
        this.usageAmount = usageAmount;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        if (billAmount < 0) {
            throw new IllegalArgumentException("BillAmount should be greater than or equal to 0");
        }
        this.billAmount = billAmount;
    }

    public Date getUsageDate() {
        return usageDate;
    }

    public void setUsageDate(Date usageDate) {
        this.usageDate = usageDate;
    }

    public UserPlans getUserPlans() {
        return userPlans;
    }

    public void setUserPlans(UserPlans userPlans) {
        this.userPlans = userPlans;
    }
}