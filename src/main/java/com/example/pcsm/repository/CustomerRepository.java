package com.example.ctsproject.repository;

import com.example.ctsproject.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CustomerRepository extends JpaRepository<Customer, Long> {
   Customer findByEmail(String email);
}