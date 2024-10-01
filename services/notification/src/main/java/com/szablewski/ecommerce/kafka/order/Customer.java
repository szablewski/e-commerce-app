package com.szablewski.ecommerce.kafka.order;

public record Customer(
        String id,
        String firstName,
        String lastname,
        String email
) {
}
