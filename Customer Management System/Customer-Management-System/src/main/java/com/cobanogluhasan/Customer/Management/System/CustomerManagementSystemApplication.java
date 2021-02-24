package com.cobanogluhasan.Customer.Management.System;

import com.cobanogluhasan.Customer.Management.System.model.Customer;
import com.cobanogluhasan.Customer.Management.System.model.Order;
import com.cobanogluhasan.Customer.Management.System.repository.CustomerRepository;
import com.cobanogluhasan.Customer.Management.System.repository.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerManagementSystemApplication.class, args);
	}
}
