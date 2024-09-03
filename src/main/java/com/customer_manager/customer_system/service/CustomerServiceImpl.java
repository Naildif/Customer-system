package com.customer_manager.customer_system.service;

import com.customer_manager.customer_system.dto.CustomerDTO;
import com.customer_manager.customer_system.entity.Customer;
import com.customer_manager.customer_system.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService{
    private  final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    @Override
    public CustomerDTO getCustomerById(Long id) {
        Optional<Customer> customer =customerRepository.findById(id);
        return customer.map(this::convertEntityToDTO).orElse(null);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(this::convertEntityToDTO).collect(Collectors.toList());
    }

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO){
        Customer customer = convertDTOToEntity(customerDTO);

        Customer savedCustomer = customerRepository.save(customer);
        return convertEntityToDTO(savedCustomer);
    }

    @Override
    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) {
        Optional<Customer> existingCustomer = customerRepository.findById(id);
        if (existingCustomer.isPresent()) {
            Customer customerToUpdate = existingCustomer.get();
            customerToUpdate.setName(customerDTO.getName());
            customerToUpdate.setAge(customerDTO.getAge());
            customerToUpdate.setPhoneNumber(customerDTO.getPhoneNumber());
            Customer updatedCustomer = customerRepository.save(customerToUpdate);
            return convertEntityToDTO(updatedCustomer);
        }
        return null;
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    private CustomerDTO convertEntityToDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setName(customer.getName());
        customerDTO.setAge(customer.getAge());
        customerDTO.setPhoneNumber(customer.getPhoneNumber());
        return customerDTO;
    }
    private Customer convertDTOToEntity(CustomerDTO customerDTO) {
        Customer customer= new Customer();
        customer.setName(customerDTO.getName());
        customer.setAge(customerDTO.getAge());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());
        return customer;
    }
}
