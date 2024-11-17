package com.szablewski.ecommerce.customer;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Validated
class Address {

    private String street;
    private String houseNumber;
    private String zipCode;
}
