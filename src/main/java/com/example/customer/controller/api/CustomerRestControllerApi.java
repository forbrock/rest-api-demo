package com.example.customer.controller.api;

import com.example.customer.model.Customer;
import com.example.customer.model.CustomerDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerRestControllerApi {

    @Operation(summary = "Get customer by id", responses = {
        @ApiResponse(responseCode = "200", description = "Successful Operation",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = Customer.class))),
        @ApiResponse(responseCode = "400", description = "Bad Request"),
        @ApiResponse(responseCode = "404", description = "Not Found")})
    ResponseEntity<Customer> getCustomer(Long customerId);

    @Operation(summary = "Save customer", responses = {
        @ApiResponse(responseCode = "201", description = "Successful Operation",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = CustomerDto.class))),
        @ApiResponse(responseCode = "400", description = "Bad Request")})
    ResponseEntity<CustomerDto> saveCustomer(CustomerDto dto);

    @Operation(summary = "Update customer using id", responses = {
        @ApiResponse(responseCode = "200", description = "Successful Operation",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = Customer.class))),
        @ApiResponse(responseCode = "400", description = "Bad Request"),
        @ApiResponse(responseCode = "404", description = "Not Found")})
    ResponseEntity<Customer> updateCustomer(Long customerId, CustomerDto dto);

    @Operation(summary = "Delete customer using id", responses = {
        @ApiResponse(responseCode = "204", description = "Successful Operation"),
        @ApiResponse(responseCode = "404", description = "Not Found")})
    ResponseEntity<Customer> deleteCustomer(Long customerId);

    @Operation(summary = "Get all customers", responses = {
        @ApiResponse(responseCode = "200", description = "Successful Operation",
            content = @Content(mediaType = "application/json",
                array = @ArraySchema(schema = @Schema(implementation = Customer.class)))),
        @ApiResponse(responseCode = "404", description = "Not Found")})
    ResponseEntity<List<Customer>> getAllCustomers();
}
