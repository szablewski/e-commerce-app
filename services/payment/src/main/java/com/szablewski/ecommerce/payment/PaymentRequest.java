package com.szablewski.ecommerce.payment;

import java.math.BigDecimal;

record PaymentRequest(
        Integer id,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        Customer customer
) {
}
