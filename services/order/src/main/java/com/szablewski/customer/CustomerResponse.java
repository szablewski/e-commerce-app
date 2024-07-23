package com.szablewski.customer;

public record CustomerResponse(
        String customerId,
        String firstname,
        String lastname,
        String email
) {
}
