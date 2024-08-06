package com.szablewski.orderLine;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderLineService {

    private final OrderLineRepository repository;
    private final OrderLineMapper mapper;
    public Integer saveOrderLine(OrderLineRequest orderLineRequest) {
        var orderLine = mapper.toOrderLine(orderLineRequest);
        return repository.save(orderLine).getOrderLineId();
    }

    public List<OrderLineResponse> findByOrderId(Integer orderId) {
        return repository.findAllByOrderByOrderLineId(orderId)
                .stream()
                .map(mapper::toOrderLineResponse)
                .collect(Collectors.toList());
    }
}
