package com.cobanogluhasan.Customer.Management.System.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table
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
    private Customer customer;

    @ManyToOne
    //join table it'll hold the relationship  between orders table and customers table
    @JoinTable(name = "customers_order", joinColumns = @JoinColumn(name ="order_id" ),
             inverseJoinColumns = @JoinColumn(name = "customers_id"))
    private Set<Order> orders = new HashSet<>();

    public Order() {
    }

    public Order(String details, int amount) {
        this.details = details;
        this.amount = amount;
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

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", details='" + details + '\'' +
                ", amount=" + amount +
                ", customer=" + customer +
                ", orders=" + orders +
                '}';
    }
}
