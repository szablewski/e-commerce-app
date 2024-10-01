package com.szablewski.ecommerce.notification;

import com.szablewski.ecommerce.kafka.payment.PaymentMethod;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<Notification, String> {
}
