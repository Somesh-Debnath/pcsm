package com.example.ctsproject.service;


import com.example.ctsproject.model.Customer;

import com.example.ctsproject.exeception.CustomerAlreadyExistsException;

import com.example.ctsproject.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

@Service

public class CustomerService {

    @Autowired

    private CustomerRepository customerRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Customer registerCustomer(Customer customer) {

        // Check if the email is already registered

        if (customerRepository.findByEmail(customer.getEmail()) != null) {

            throw new CustomerAlreadyExistsException("Customer already registered with this email");

        }

        // Encrypt the password before saving

        customer.setPassword(passwordEncoder.encode(customer.getPassword()));

        customer.setApproved(false); // Set approved to false on registration

        return customerRepository.save(customer);

    }

    // Method to approve customer

    public Customer approveCustomer(Long customerId) {

        Customer customer = customerRepository.findById(customerId)

                .orElseThrow(() -> new RuntimeException("Customer not found"));

        customer.setApproved(true);

        return customerRepository.save(customer);

    }

} 