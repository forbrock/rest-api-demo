package com.example.customer.mapper;

import com.example.customer.model.Customer;
import com.example.customer.model.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CustomerMapper {

    Customer map(CustomerDto dto);
    Customer mapTo(CustomerDto dto, @MappingTarget Customer customer);
}
