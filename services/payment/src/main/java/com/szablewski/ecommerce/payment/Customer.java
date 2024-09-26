package com.szablewski.ecommerce.payment;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public record Customer(
        Integer id,
        @NotNull(message = "Firstname is required")
        String firstName,
        @NotNull(message = "Lastname is required")
        String lastname,
        @NotNull(message = "Email is required")
        @Email(message = "Email is not correctly formated")
        String email
) {
}
