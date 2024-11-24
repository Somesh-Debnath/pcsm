package com.example.ctsproject.controller;

import com.example.ctsproject.entity.Customer;
import com.example.ctsproject.exeception.CustomerAlreadyExistsException;
import com.example.ctsproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/registration")
public class CustomerController {
   @Autowired
   private CustomerService customerService;
   @PostMapping
   public Customer registerCustomer(@RequestBody Customer customer) {
       return customerService.registerCustomer(customer);
   }
   @PutMapping("/admin/approve/{customerId}")
   public Customer approveCustomer(@PathVariable Long customerId) {
       return customerService.approveCustomer(customerId);
   }
   @ExceptionHandler(CustomerAlreadyExistsException.class)
   @ResponseStatus(HttpStatus.BAD_REQUEST)
   public String handleCustomerAlreadyExistsException(CustomerAlreadyExistsException ex) {
       return ex.getMessage();
   }
}
