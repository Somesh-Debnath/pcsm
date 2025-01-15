package com.pcms.pcms_backend.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "usage_data")
public class Usage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usageBillId;

    private Long usageAmount;

    private Long billAmount;

    @Temporal(TemporalType.DATE)
    private Date usageDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userPlanId")
    private UserPlans userPlans;

    // Getters and setters

    public Long getUsageBillId() {
        return usageBillId;
    }

    public void setUsageBillId(Long usageBillId) {
        this.usageBillId = usageBillId;
    }


    public Long getUsageAmount() {
        return usageAmount;
    }

    public void setUsageAmount(Long usageAmount) {
        this.usageAmount = usageAmount;
    }

    public Long getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(Long billAmount) {
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

    public Usage(Long usageBillId, Long usageAmount, Long billAmount, Date usageDate, UserPlans userPlans) {
        this.usageBillId = usageBillId;
        this.usageAmount = usageAmount;
        this.billAmount = billAmount;
        this.usageDate = usageDate;
        this.userPlans = userPlans;
    }

    public Usage() {
    }
}