package com.szablewski.ecommerce.payment;

import com.szablewski.ecommerce.notification.NotificationProducer;
import com.szablewski.ecommerce.notification.PaymentNotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository repository;
    private final PaymentMapper mapper;
    private final NotificationProducer producer;

    public Integer createPayment(PaymentRequest request) {
        var payment = repository.save(mapper.toPayment(request));

        producer.sendNotification(
                new PaymentNotificationRequest(
                        request.orderReference(),
                        request.amount(),
                        request.paymentMethod(),
                        request.customer().firstName(),
                        request.customer().lastname(),
                        request.customer().email()
                )
        );
        return payment.getId();
    }
}
