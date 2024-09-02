package com.customer_manager.customer_system.service;

import com.customer_manager.customer_system.dto.CustomerDTO;

public interface CustomerService {
    CustomerDTO getCustomerbyId(Long id);
    CustomerDTO createCustomer(CustomerDTO customerDTO);
    CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO);
    void deleteCustomerbyId(Long id);

}
