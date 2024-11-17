package com.szablewski.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAllByProductIdInOrderByProductId(List<Integer> productIds);
}
