package com.inventory.inventory_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.inventory_service.domain.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    Inventory findByProductId(Long productId);
}