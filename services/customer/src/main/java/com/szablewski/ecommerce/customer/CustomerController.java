package com.szablewski.ecommerce.customer;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
class CustomerController {

    private final CustomerService service;

    @PostMapping
    ResponseEntity<String> createCustomer(@RequestBody @Valid final CustomerRequest request) {
        return ResponseEntity.ok(service.createCustomer(request));
    }

    @PutMapping
    ResponseEntity<Void> updateCustomer(@RequestBody @Valid final CustomerRequest request) {
        service.updateCustomer(request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    ResponseEntity<List<CustomerResponse>> findAll() {
        return ResponseEntity.ok(service.findAllCustomer());
    }

    @GetMapping("/exits/{customer-id}")
    ResponseEntity<Boolean> existsById(@PathVariable("customer-id") final String customerId) {
        return ResponseEntity.ok(service.existsById(customerId));
    }

    @GetMapping("/{customer-id}")
    ResponseEntity<CustomerResponse> findById(@PathVariable("customer-id") final String customerId) {
        return ResponseEntity.ok(service.findById(customerId));
    }

    @DeleteMapping("/{customer-id}")
    ResponseEntity<Void> deleteCustomer(@PathVariable("customer-id") final String customerId) {
        service.deleteCustomer(customerId);
        return ResponseEntity.accepted().build();
    }
}
