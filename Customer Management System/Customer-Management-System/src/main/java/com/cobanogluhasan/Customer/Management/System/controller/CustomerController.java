package com.cobanogluhasan.Customer.Management.System.controller;

import com.cobanogluhasan.Customer.Management.System.exception.ResourceNotFoundException;
import com.cobanogluhasan.Customer.Management.System.model.Customer;
import com.cobanogluhasan.Customer.Management.System.model.Order;
import com.cobanogluhasan.Customer.Management.System.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @PostMapping("customers")
    public Customer createCustomer(@RequestBody Customer customer) {
        return this.customerRepository.save(customer);
    }
    //update customer
    @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(
            @PathVariable(value = "id") Long customerId,
            @Validated @RequestBody Customer customerDetails) throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found for that id" + customerId));

        customer.setEmail(customerDetails.getEmail());
        customer.setFullName(customerDetails.getFullName());
        customer.setOrders(customerDetails.getOrders());

        return ResponseEntity.ok(this.customerRepository.save(customer));
    }

    //delete customer
    @DeleteMapping("/customers/{id}")
    public Map<String, Boolean> deleteCustomer(@PathVariable(value = "id") Long customerId) throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found for that id" + customerId));

        this.customerRepository.delete(customer);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
