package com.example.ctsproject.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Customer {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String fullName;
   private String phoneNumber;
   private String email;
   private String ssn;
   private String addressLine1;
   private String addressLine2;
   private String zipCode;
   private String password;
   
   private boolean isApproved = false; // New field for admin approval
}