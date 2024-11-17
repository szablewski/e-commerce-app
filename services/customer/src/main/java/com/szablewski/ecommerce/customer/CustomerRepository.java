package com.szablewski.ecommerce.customer;

import org.springframework.data.mongodb.repository.MongoRepository;

interface CustomerRepository extends MongoRepository<Customer, String> {
}
