package com.price.price_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.price.price_service.domain.Price;

public interface PriceRepository extends JpaRepository<Price, Long> {
    Price findByProductId(Long productId);
}
