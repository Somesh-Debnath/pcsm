package com.pcms.pcms_backend.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class BillRequestDTO {
    private int userPlanId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date from;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date to;

    // Getters and Setters
    public int getUserPlanId() {
        return userPlanId;
    }

    public void setUserPlanId(int userPlanId) {
        this.userPlanId = userPlanId;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }
}