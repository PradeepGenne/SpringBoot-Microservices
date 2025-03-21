package com.product.product_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.product.product_service.domain.Price;


@FeignClient(name = "price-service")
public interface PriceServiceClient {
    
    @GetMapping("/prices/{productId}")
    Price getPrice(@PathVariable("productId") Long productId);
}
