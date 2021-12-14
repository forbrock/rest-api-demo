package com.example.customer.service;

import com.example.customer.model.Customer;
import com.example.customer.model.CustomerDto;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Optional<Customer> findById(Long id);

    void save(CustomerDto dto);

    void update(Customer customer, CustomerDto dto);

    void delete(Long id);

    List<Customer> getAll();
}
