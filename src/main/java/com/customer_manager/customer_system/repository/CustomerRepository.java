package com.customer_manager.customer_system.repository;

import com.customer_manager.customer_system.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
