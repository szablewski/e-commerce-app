package com.szablewski.kafka;

import com.szablewski.customer.CustomerResponse;
import com.szablewski.order.PaymentMethod;
import com.szablewski.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products
) {
}
