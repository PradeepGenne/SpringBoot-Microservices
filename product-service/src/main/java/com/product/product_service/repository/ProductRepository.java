package com.product.product_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.product_service.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryId(Long categoryId);
}
