package com.example.ctsproject.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
   // Getters and Setters
   public boolean isApproved() {
       return isApproved;
   }
   public void setApproved(boolean approved) {
       isApproved = approved;
   }
   // Getters and Setters
   public Long getId() {
       return id;
   }
   public void setId(Long id) {
this.id = id;
   }
   public String getFullName() {
       return fullName;
   }
   public void setFullName(String fullName) {
       this.fullName = fullName;
   }
   public String getPhoneNumber() {
       return phoneNumber;
   }
   public void setPhoneNumber(String phoneNumber) {
       this.phoneNumber = phoneNumber;
   }
   public String getEmail() {
       return email;
   }
   public void setEmail(String email) {
       this.email = email;
   }
   public String getSsn() {
       return ssn;
   }
   public void setSsn(String ssn) {
       this.ssn = ssn;
   }
   public String getAddressLine1() {
       return addressLine1;
   }
   public void setAddressLine1(String addressLine1) {
       this.addressLine1 = addressLine1;
   }
   public String getAddressLine2() {
       return addressLine2;
   }
   public void setAddressLine2(String addressLine2) {
       this.addressLine2 = addressLine2;
   }
   public String getZipCode() {
       return zipCode;
   }
   public void setZipCode(String zipCode) {
       this.zipCode = zipCode;
   }
   public String getPassword() {
       return password;
   }
   public void setPassword(String password) {
       this.password = password;
   }
}