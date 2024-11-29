package com.szablewski.orderLine;

import com.szablewski.order.Order;
import org.springframework.stereotype.Service;

@Service
class OrderLineMapper {

    OrderLine toOrderLine(OrderLineRequest orderLineRequest) {
        return OrderLine.builder()
                .orderLineId(orderLineRequest.id())
                .quantity(orderLineRequest.quantity())
                .order(Order.builder()
                                .orderId(orderLineRequest.orderId())
                                .build())
                .build();
    }

    OrderLineResponse toOrderLineResponse(OrderLine orderLine) {
        return new OrderLineResponse(orderLine.getOrderLineId(), orderLine.getQuantity());
    }
}
