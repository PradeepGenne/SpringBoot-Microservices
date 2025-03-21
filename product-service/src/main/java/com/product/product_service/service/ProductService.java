package com.product.product_service.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.product_service.client.InventoryServiceClient;
import com.product.product_service.client.PriceServiceClient;
import com.product.product_service.domain.Inventory;
import com.product.product_service.domain.Price;
import com.product.product_service.domain.Product;
import com.product.product_service.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
    private ProductRepository productRepository;

    @Autowired
    private PriceServiceClient priceServiceClient;

    @Autowired
    private InventoryServiceClient inventoryServiceClient;

    public Product getProductDetails(Long productId) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product != null) {
            Price price = priceServiceClient.getPrice(productId);
            Inventory inventory = inventoryServiceClient.getInventory(productId);

            if (price != null) product.setPrice(price.getPrice());
            if (inventory != null) product.setStockLevel(inventory.getStockLevel());
        }
        return product;
    }

    public List<Product> getProductsByCategory(Long categoryId) {
        List<Product> products = productRepository.findByCategoryId(categoryId);
        for (Product product : products) {
            // Fetch price and inventory details for each product
            Price price = priceServiceClient.getPrice(product.getId());
            Inventory inventory = inventoryServiceClient.getInventory(product.getId());

            if (price != null) product.setPrice(price.getPrice());
            if (inventory != null) product.setStockLevel(inventory.getStockLevel());
        }
        return products;
    }
}
