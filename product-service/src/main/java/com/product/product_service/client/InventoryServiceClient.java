package com.product.product_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.product.product_service.domain.Inventory;


@FeignClient(name = "inventory-service")
public interface InventoryServiceClient {

    @GetMapping("/inventory/{productId}")
    Inventory getInventory(@PathVariable("productId") Long productId);
}

