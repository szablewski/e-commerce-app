package com.szablewski.ecommerce.customer;

public record CustomerResponse(
        String customerId,
        String firstname,
        String lastname,
        String email,
        Address address
) {
}
