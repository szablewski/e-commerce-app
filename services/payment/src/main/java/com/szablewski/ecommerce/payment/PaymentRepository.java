package com.szablewski.ecommerce.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PaymentRepository extends JpaRepository<Payment, Long> {
}
