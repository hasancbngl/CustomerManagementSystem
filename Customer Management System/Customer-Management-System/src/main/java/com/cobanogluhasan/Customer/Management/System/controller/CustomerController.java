package com.cobanogluhasan.Customer.Management.System.controller;

import com.cobanogluhasan.Customer.Management.System.exception.ResourceNotFoundException;
import com.cobanogluhasan.Customer.Management.System.model.Customer;
import com.cobanogluhasan.Customer.Management.System.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/api/v1/")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    //get customers
    @GetMapping("customers")
    public List<Customer> getCustomers() {
        return this.customerRepository.findAll();
    }

    //get customer by id
    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") Long customerId)
     throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found for that id" + customerId));
        return ResponseEntity.ok().body(customer);
    }

    //save customer
    public Customer createCustomer(@RequestBody Customer customer) {
        return this.customerRepository.save(customer);
    }

    //update customer

    //delete customer
}
