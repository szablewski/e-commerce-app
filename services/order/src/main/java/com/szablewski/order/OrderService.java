package com.szablewski.order;

import com.szablewski.customer.CustomerClient;
import com.szablewski.exception.BusinessException;
import com.szablewski.kafka.OrderConfirmation;
import com.szablewski.kafka.OrderProducer;
import com.szablewski.orderLine.OrderLineRequest;
import com.szablewski.orderLine.OrderLineService;
import com.szablewski.product.ProductClient;
import com.szablewski.product.PurchaseRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderMapper mapper;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;
    public Integer createOrder(OrderRequest request) {
        var customer = this.customerClient.findCustomerId(request.customerId())
                .orElseThrow(() -> new BusinessException("Cannot create order:: No customer exists with the provided ID::"));

        var purchasedProducts =  this.productClient.purchaseProducts(request.products());

        var order = this.repository.save(mapper.toOrder(request));

        for (PurchaseRequest purchaseRequest : request.products()) {
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getOrderId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    )
            );
        }

        orderProducer.sendOrderConfirmation(
                new OrderConfirmation(
                        request.reference(),
                        request.amount(),
                        request.paymentMethod(),
                        customer,
                        purchasedProducts
                )
        );

        return order.getOrderId();
    }
}
