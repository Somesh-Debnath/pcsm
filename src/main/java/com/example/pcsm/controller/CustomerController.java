package com.example.pcsm.controller;

import com.example.pcsm.dto.CustomerDto;
import com.example.pcsm.model.Customer;
import com.example.pcsm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    // Endpoint to register a new customer
    @PostMapping("/register")
    public ResponseEntity<Customer> registerCustomer(@RequestBody CustomerDto customerDto) {
        Customer customer = customerService.registerCustomer(customerDto);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }
    // Endpoint for admin to approve the customer
    @PutMapping("/approve/{customerId}")
    public ResponseEntity<String> approveCustomer(@PathVariable Long customerId) {
        customerService.approveCustomer(customerId);
        return new ResponseEntity<>("Customer Approved", HttpStatus.OK);
    }
}