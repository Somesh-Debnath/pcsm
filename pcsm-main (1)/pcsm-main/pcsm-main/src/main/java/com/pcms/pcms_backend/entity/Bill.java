package com.pcms.pcms_backend.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer billId;

    @Column(insertable = false, updatable = false)
    private Integer userPlanId;

    private Double billAmount;

    private Date billDate;

    private String dueDate;

    private Date paymentDate;

    private String paymentStatus;

    private String paymentMethod;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userPlanId")
    private UserPlans userPlans;

    // Getters and setters

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public Double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(Double billAmount) {
        this.billAmount = billAmount;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public Integer getUserPlanId() {
        return userPlanId;
    }

    public void setUserPlanId(Integer userPlanId) {
        this.userPlanId = userPlanId;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public UserPlans getUserPlans() {
        return userPlans;
    }

    public void setUserPlans(UserPlans userPlans) {
        this.userPlans = userPlans;
    }

    public Bill(Integer billId, Integer userPlanId, Double billAmount, Date billDate, String dueDate, Date paymentDate, String paymentStatus, String paymentMethod, UserPlans userPlans) {
        this.billId = billId;
        this.userPlanId = userPlanId;
        this.billAmount = billAmount;
        this.billDate = billDate;
        this.dueDate = dueDate;
        this.paymentDate = paymentDate;
        this.paymentStatus = paymentStatus;
        this.paymentMethod = paymentMethod;
        this.userPlans = userPlans;
    }

    public Bill() {
    }
}