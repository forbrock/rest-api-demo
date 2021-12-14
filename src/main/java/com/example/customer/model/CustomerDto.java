package com.example.customer.model;

import lombok.Value;

import javax.validation.constraints.NotEmpty;

@Value
public class CustomerDto {

    @NotEmpty
    String firstName;
    @NotEmpty
    String lastName;
    @NotEmpty
    String address;
}
