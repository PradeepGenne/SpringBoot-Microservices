package com.inventory.inventory_service.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.inventory_service.domain.Inventory;
import com.inventory.inventory_service.repository.InventoryRepository;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public Inventory getInventory(Long productId) {
        return inventoryRepository.findByProductId(productId);
    }

    public Inventory createOrUpdateInventory(Long productId, int stockLevel) {
        Inventory inventory = inventoryRepository.findByProductId(productId);
        if (inventory == null) {
            inventory = new Inventory();
            inventory.setProductId(productId);
        }
        inventory.setStockLevel(stockLevel);
        return inventoryRepository.save(inventory);
    }
}
