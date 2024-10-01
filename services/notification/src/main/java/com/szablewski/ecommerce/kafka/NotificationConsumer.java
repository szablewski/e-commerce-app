package com.szablewski.ecommerce.kafka;

import com.szablewski.ecommerce.kafka.order.OrderConfirmation;
import com.szablewski.ecommerce.kafka.payment.PaymentConfirmation;
import com.szablewski.ecommerce.notification.Notification;
import com.szablewski.ecommerce.notification.NotificationRepository;
import com.szablewski.ecommerce.notification.NotificationType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.szablewski.ecommerce.notification.NotificationType.ORDER_CONFIRMATION;
import static com.szablewski.ecommerce.notification.NotificationType.PAYMENT_CONFIRMATION;
import static java.lang.String.format;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {

    private final NotificationRepository repository;
    // private final EmailService emailService;

    @KafkaListener(topics = "payment-topic")
    public void consumePaymentSuccessNotification(PaymentConfirmation paymentConfirmation) {
        log.info("Consuming the message from payment-topic Topic:: {}", paymentConfirmation);
        repository.save(
                Notification.builder()
                        .type(PAYMENT_CONFIRMATION)
                        .notificationDate(LocalDateTime.now())
                        .paymentConfirmation(paymentConfirmation)
                        .build()
        );

        // todo send email
    }

    @KafkaListener(topics = "order-topic")
    public void consumeOrderConfirmationNotification(OrderConfirmation orderConfirmation) {
        log.info("Consuming the message from order-topic Topic:: {}", orderConfirmation);
        repository.save(
                Notification.builder()
                        .type(ORDER_CONFIRMATION)
                        .notificationDate(LocalDateTime.now())
                        .orderConfirmation(orderConfirmation)
                        .build()
        );

        // todo send email
    }
}
