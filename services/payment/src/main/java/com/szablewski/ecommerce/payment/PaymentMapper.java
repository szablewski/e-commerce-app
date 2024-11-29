package com.szablewski.ecommerce.payment;

import org.springframework.stereotype.Service;

@Service
class PaymentMapper {

    Payment toPayment(final PaymentRequest request) {
        return Payment.builder()
                .id(request.id())
                .orderId(request.orderId())
                .amount(request.amount())
                .paymentMethod(request.paymentMethod())
                .build();
    }
}
