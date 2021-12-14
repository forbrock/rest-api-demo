package com.example.customer.service.impl;

import com.example.customer.mapper.CustomerMapper;
import com.example.customer.model.Customer;
import com.example.customer.model.CustomerDto;
import com.example.customer.repository.CustomerRepository;
import com.example.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(CustomerDto dto) {
        var customer = customerMapper.map(dto);
        customerRepository.save(customer);
    }

    @Override
    public void update(Customer customer, CustomerDto dto) {
        var updatedCustomer = customerMapper.mapTo(dto, customer);
        customerRepository.save(updatedCustomer);
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }
}
