package com.cobanogluhasan.Customer.Management.System.controller;

import com.cobanogluhasan.Customer.Management.System.exception.ResourceNotFoundException;
import com.cobanogluhasan.Customer.Management.System.model.Order;
import com.cobanogluhasan.Customer.Management.System.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping( "/api/v1/")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    //get orders
    @GetMapping("orders")
    public List<Order> getOrders() {
        return this.orderRepository.findAll();
    }

    //get order by id
    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable(value = "id") Long orderId)
     throws ResourceNotFoundException {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found for that id" + orderId));
        return ResponseEntity.ok().body(order);
    }

    //save order
    @PostMapping("orders")
    public Order createOrder(@RequestBody Order order) {
        return this.orderRepository.save(order);
    }

    //update order
    @PutMapping("/orders/{id}")
    public ResponseEntity<Order> updateOrder(
            @PathVariable(value = "id") Long orderId,
            @Validated @RequestBody Order orderDetails) throws ResourceNotFoundException {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found for that id" + orderId));
        order.setOrders(orderDetails.getOrders());
        order.setAmount(orderDetails.getAmount());
        order.setCustomer(orderDetails.getCustomer());
        order.setDetails(orderDetails.getDetails());

        return ResponseEntity.ok(this.orderRepository.save(order));
    }

    //delete order
    @DeleteMapping("/orders/{id}")
    public Map<String, Boolean> deleteOrder(@PathVariable(value = "id") Long orderId) throws ResourceNotFoundException {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found for that id" + orderId));

        this.orderRepository.delete(order);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
