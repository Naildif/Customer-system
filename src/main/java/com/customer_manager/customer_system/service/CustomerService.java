package com.customer_manager.customer_system.service;

import com.customer_manager.customer_system.dto.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {
    CustomerDTO getCustomerById(Long id);
    List<CustomerDTO> getAllCustomers();
    CustomerDTO createCustomer(CustomerDTO customerDTO);
    CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO);
    void deleteCustomer(Long id);

}
