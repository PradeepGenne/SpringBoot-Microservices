package com.product.product_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.product.product_service.domain.Category;
import com.product.product_service.domain.Product;
import com.product.product_service.repository.CategoryRepository;
import com.product.product_service.repository.ProductRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public DataLoader(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Category electronics = new Category();
        electronics.setName("Electronics");
        categoryRepository.save(electronics);

        Category clothing = new Category();
        clothing.setName("Clothing");
        categoryRepository.save(clothing);

        Product phone = new Product();
        phone.setName("Smartphone");
        phone.setPrice(599.99);
        phone.setStockLevel(100);
        phone.setCategory(electronics);
        productRepository.save(phone);

        Product tshirt = new Product();
        tshirt.setName("T-Shirt");
        tshirt.setPrice(19.99);
        tshirt.setStockLevel(150);
        tshirt.setCategory(clothing);
        productRepository.save(tshirt);
    }
}