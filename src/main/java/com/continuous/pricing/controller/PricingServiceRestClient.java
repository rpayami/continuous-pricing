package com.continuous.pricing.controller;


import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class PricingServiceRestClient {
    private final RestClient restClient;

    public PricingServiceRestClient(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("http://localhost:8080/v1/pricing")
                .build();
    }

    public Integer getAmount(PricingServiceDTO pricingServiceDTO) {
        return restClient.post()
                .body(pricingServiceDTO)
                .retrieve()
                .body(Integer.class);
    }

}
