package com.pcms.pcms_backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Plans {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int planId;

    private String planName;

    private String location;

    private double price;

    private String description;

    private String status;

    @ManyToOne
    @JoinColumn(name = "userPlanId")
    private UserPlans userPlans;


    public Plans(int planId, String planName, String location, double price, String description) {
        super();
        this.planId = planId;
        this.planName = planName;
        this.location = location;
        this.price = price;
        this.description = description;
    }

    public Plans() {
        super();
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price should be greater than 0");
        }
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}