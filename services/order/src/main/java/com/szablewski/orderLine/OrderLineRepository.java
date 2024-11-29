package com.szablewski.orderLine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {

    @Query("select o from OrderLine o where o.order.orderId = :orderId")
    List<OrderLine> findAllByOrderId(Integer orderId);
}
