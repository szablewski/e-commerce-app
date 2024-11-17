package com.szablewski.ecommerce.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

record CustomerRequest(
        String customerId,
        @NotNull(message = "Customer firstname is required")
        String firstname,
        @NotNull(message = "Customer lastname is required")
        String lastname,

        @NotNull(message = "Customer email is required")
        @Email(message = "Customer email is not a valid email address")
        String email,
        Address address

) {
}
