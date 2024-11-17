package com.szablewski.ecommerce.customer;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Document
class Customer {

    @Id
    private String customerId;
    private String firstname;
    private String lastname;
    private String email;
    private Address address;
}
