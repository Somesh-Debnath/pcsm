package com.pcms.pcms_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Plans {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int planId;
    private String planName;
    private String location;

    private double price;

    public Plans(int planId, String planName, String location, double price) {
        super();
        this.planId = planId;
        this.planName = planName;
        this.location = location;
        this.price = price;
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

    public void setPlan_Name(String planName) {
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
        this.price = price;
    }


}
