package com.szablewski.ecommerce.customer;

import com.szablewski.ecommerce.exception.CustomerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
class CustomerService {
    private static final String CUSTOMER_NOT_FOUND = "No customer found with the provided ID:: %s";

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

     String createCustomer(final CustomerRequest request) {
        var customer = repository.save(mapper.toCustomer(request));
        return customer.getCustomerId();
    }

     void updateCustomer(final CustomerRequest request) {
        var customer = repository.findById(request.customerId())
                .orElseThrow(() -> new CustomerNotFoundException(
                        format("Cannot update customer:: " + CUSTOMER_NOT_FOUND, request.customerId())));
        mergerCustomer(customer, request);
        repository.save(customer);
    }

     List<CustomerResponse> findAllCustomer() {
        return repository.findAll()
                .stream()
                .map(mapper::fromCustomer)
                .toList();
    }

     Boolean existsById(final String customerId) {
        return repository.findById(customerId)
                .isPresent();
    }

     CustomerResponse findById(final String customerId) {
        return repository.findById(customerId)
                .map(mapper::fromCustomer)
                .orElseThrow(() -> new CustomerNotFoundException(format(CUSTOMER_NOT_FOUND, customerId)));
    }

     void deleteCustomer(final String customerId) {
        repository.deleteById(customerId);
    }

    private void mergerCustomer(final Customer customer, final CustomerRequest request) {
        if (StringUtils.isNotBlank(request.firstname())) {
            customer.setFirstname(request.firstname());
        }
        if (StringUtils.isNotBlank(request.lastname())) {
            customer.setLastname(request.lastname());
        }
        if (StringUtils.isNotBlank(request.email())) {
            customer.setEmail(request.email());
        }
        if (request.address() != null) {
            customer.setAddress(request.address());
        }
    }
}
