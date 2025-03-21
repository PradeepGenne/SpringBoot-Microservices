package com.inventory.inventory_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.inventory_service.domain.Inventory;
import com.inventory.inventory_service.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/{productId}")
    public Inventory getInventory(@PathVariable Long productId) {
        return inventoryService.getInventory(productId);
    }

    @PostMapping("/{productId}")
    public Inventory createOrUpdateInventory(@PathVariable Long productId, @RequestParam int stockLevel) {
        return inventoryService.createOrUpdateInventory(productId, stockLevel);
    }
}
