package com.example.customer.controller;

import com.example.customer.controller.api.CustomerRestControllerApi;
import com.example.customer.model.Customer;
import com.example.customer.model.CustomerDto;
import com.example.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerRestController implements CustomerRestControllerApi {

    private final CustomerService customerService;


    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long customerId) {
        if (customerId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return customerService.findById(customerId)
                .map(customer -> new ResponseEntity<>(customer, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    @PostMapping
    public ResponseEntity<CustomerDto> saveCustomer(@RequestBody @Valid CustomerDto dto) {
        if (dto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        customerService.save(dto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @Override
    @PatchMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Long customerId,
                                                   @RequestBody CustomerDto dto) {
        if (dto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        var customer = customerService.findById(customerId);
        if (customer.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        customerService.update(customer.get(), dto);
        return new ResponseEntity<>(customer.get(), HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Long customerId) {
        var customer = customerService.findById(customerId);
        if (customer.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        customerService.delete(customerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        var customers = customerService.getAll();
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
}
