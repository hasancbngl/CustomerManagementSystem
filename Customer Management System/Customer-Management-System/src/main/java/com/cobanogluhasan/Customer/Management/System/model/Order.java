package com.cobanogluhasan.Customer.Management.System.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "orders")
public class Order {
    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "order_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )
    private long id;

    private String details;
    private int amount;

    //ManytoOne relationship. Orders or one order can be related to one customer
    @ManyToOne
    @JoinColumn(name = "customer", nullable = false)
    private Customer customer;


    public Order(String details, int amount, Customer customer) {
        this.details = details;
        this.amount = amount;
        this.customer = customer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", details='" + details + '\'' +
                ", amount=" + amount +
                ", customer=" + customer +
                '}';
    }
}
