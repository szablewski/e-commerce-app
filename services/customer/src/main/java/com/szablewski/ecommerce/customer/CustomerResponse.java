package com.szablewski.ecommerce.customer;

record CustomerResponse(
        String customerId,
        String firstname,
        String lastname,
        String email,
        Address address
) {
}
