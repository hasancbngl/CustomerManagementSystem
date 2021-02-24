package com.cobanogluhasan.Customer.Management.System.repository;

import com.cobanogluhasan.Customer.Management.System.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository annotates classes at the persistence layer, which will act as a database repository
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
