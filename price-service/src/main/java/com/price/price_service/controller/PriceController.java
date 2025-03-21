package com.price.price_service.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.price.price_service.domain.Price;
import com.price.price_service.service.PriceService;

@RestController
@RequestMapping("/prices")
public class PriceController {

    @Autowired
    private PriceService priceService;

    @GetMapping("/{productId}")
    public Price getPrice(@PathVariable Long productId) {
        return priceService.getPrice(productId);
    }

    @PostMapping("/{productId}")
    public Price createOrUpdatePrice(@PathVariable Long productId, @RequestParam Double price) {
        return priceService.createOrUpdatePrice(productId, price);
    }
}
