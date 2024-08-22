package com.example.wishlist.integration;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalApiService {

    private final RestTemplate restTemplate;

    public ExternalApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getProductData(String productUrl) {
        // Пример получения данных о продукте по URL
        // Voorbeeld van het ophalen van productgegevens via URL
        return restTemplate.getForObject(productUrl, String.class);
    }
}
