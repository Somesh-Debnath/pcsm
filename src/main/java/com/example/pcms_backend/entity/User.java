package com.example.pcms_backend.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    @Column(unique = true) // Ensure phoneNumber is unique in the database
    private String phoneNumber;
    private String email;
    private String ssn;
    private String addressLine1;
    private String addressLine2;
    private String zipCode;
    private String password;

    private boolean isApproved = false; // New field for admin approval
}