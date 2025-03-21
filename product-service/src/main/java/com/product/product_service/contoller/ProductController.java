package com.product.product_service.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.product_service.domain.Product;
import com.product.product_service.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
    private ProductService productService;

    @GetMapping("/{productId}")
    public Product getProductDetails(@PathVariable Long productId) {
        return productService.getProductDetails(productId);
    }

    @GetMapping("/category/{categoryId}")
    public List<Product> getProductsByCategory(@PathVariable Long categoryId) {
        return productService.getProductsByCategory(categoryId);
    }
}
