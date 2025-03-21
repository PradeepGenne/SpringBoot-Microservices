package com.price.price_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.price.price_service.domain.Price;
import com.price.price_service.repository.PriceRepository;

@Service
public class PriceService {

    @Autowired
    private PriceRepository priceRepository;

    public Price getPrice(Long productId) {
        return priceRepository.findByProductId(productId);
    }

    public Price createOrUpdatePrice(Long productId, Double price) {
        Price priceObj = priceRepository.findByProductId(productId);
        if (priceObj == null) {
            priceObj = new Price();
            priceObj.setProductId(productId);
        }
        priceObj.setPrice(price);
        return priceRepository.save(priceObj);
    }
}
