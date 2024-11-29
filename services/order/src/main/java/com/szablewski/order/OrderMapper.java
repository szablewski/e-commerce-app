package com.szablewski.order;

import org.springframework.stereotype.Service;

@Service
class OrderMapper {

    Order toOrder(OrderRequest orderRequest) {
        return Order.builder()
                .orderId(orderRequest.orderId())
                .customerId(orderRequest.customerId())
                .reference(orderRequest.reference())
                .totalAmount(orderRequest.amount())
                .paymentMethod(orderRequest.paymentMethod())
                .build();
    }

    OrderResponse fromOrder(Order order) {
        return new OrderResponse(
                order.getOrderId(),
                order.getReference(),
                order.getTotalAmount(),
                order.getPaymentMethod(),
                order.getCustomerId()
        );
    }
}