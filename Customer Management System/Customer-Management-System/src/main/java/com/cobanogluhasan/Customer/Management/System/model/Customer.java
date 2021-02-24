package com.cobanogluhasan.Customer.Management.System.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

//An entity represents a table stored in a database
@Entity
@Table
public class Customer {
    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )
    private Long id;
    private String fullName;
    private String email;

    @OneToMany(mappedBy = "customers")
    private Set<Order> orders = new HashSet<>();

    public Customer() {
    }

    public Customer(String fullName, String email, Set<Order> orders) {
        this.fullName = fullName;
        this.email = email;
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", orders=" + orders +
                '}';
    }

}