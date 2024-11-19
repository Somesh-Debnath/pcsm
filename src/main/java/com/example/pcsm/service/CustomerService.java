package com.example.pcsm.service;

import com.example.pcsm.dto.CustomerDto;
import com.example.pcsm.model.Customer;
import com.example.pcsm.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer registerCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setStatus("PENDING");
        return customerRepository.save(customer);
    }

    public void approveCustomer(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        customer.setStatus("APPROVED");
        customerRepository.save(customer);
    }
}