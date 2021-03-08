package com.cobanogluhasan.Customer.Management.System.controller;

import com.cobanogluhasan.Customer.Management.System.exception.ResourceNotFoundException;
import com.cobanogluhasan.Customer.Management.System.model.Customer;
import com.cobanogluhasan.Customer.Management.System.model.Order;
import com.cobanogluhasan.Customer.Management.System.repository.CustomerRepository;
import com.cobanogluhasan.Customer.Management.System.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping( "/api/v1/customers/{customerId}/orders")
public class OrderController {

    private OrderRepository orderRepository;
    private CustomerRepository customerRepository;

    public OrderController(OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    //get orders
    @GetMapping
    public Set<Order> getOrders(@PathVariable Long customerId) {
        Customer customer = customerRepository.findById(customerId).get();
        return customer.getOrders();
    }

    //get order by id
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long customerId)
            throws ResourceNotFoundException {
        Order order = orderRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found for that id" + customerId));
        return ResponseEntity.ok().body(order);
    }

    //save order
    @PostMapping
    public Order createOrder(@PathVariable Long customerId,@RequestBody Order order) {
        Customer customer = customerRepository.findById(customerId).get();
        order.setCustomer(customer);
        return this.orderRepository.save(order);
    }

    //update order
    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(
            @PathVariable Long customerId, @RequestBody Order orderId) throws ResourceNotFoundException {
        Order order = orderRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found for that id" + customerId));

        return ResponseEntity.ok(this.orderRepository.saveAndFlush(order1));
    }

    //delete order
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteOrder(@PathVariable Long customerId) throws ResourceNotFoundException {
        Order order = orderRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found for that id" + customerId));

        this.orderRepository.delete(order);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

/*
    //update order
    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(
            @PathVariable Long customerId,
            @Validated @RequestBody Order orderDetails) throws ResourceNotFoundException {
        Order order = orderRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found for that id" + customerId));
        order.setAmount(orderDetails.getAmount());
        order.setCustomer(orderDetails.getCustomer());
        order.setDetails(orderDetails.getDetails());

        return ResponseEntity.ok(this.orderRepository.save(order));
    }

    */