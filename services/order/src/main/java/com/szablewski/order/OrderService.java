package com.szablewski.order;

import com.szablewski.customer.CustomerClient;
import com.szablewski.exception.BusinessException;
import com.szablewski.product.ProductClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final CustomerClient customerClient;
    private final ProductClient productClient;
    public Integer createOrder(OrderRequest request) {
        var customer = this.customerClient.findCustomerId(request.customerId())
                .orElseThrow(() -> new BusinessException("Cannot create order:: No customer exists with the provided ID::"));

        this.productClient.purchaseProducts(request.products());

        return null;
    }
}
