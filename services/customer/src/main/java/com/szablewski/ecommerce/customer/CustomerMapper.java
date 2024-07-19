package com.szablewski.ecommerce.customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    public Customer toCustomer(CustomerRequest request) {
        if (request == null) {
            return null;
        }
        return Customer.builder()
                .customerId(request.customerId())
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email() )
                .address(request.address())
                .build();
    }

    public CustomerResponse fromCustomer(Customer customer) {
        return new CustomerResponse(
                customer.getCustomerId(),
                customer.getFirstname(),
                customer.getLastname(),
                customer.getEmail(),
                customer.getAddress()
        );
    }
}
