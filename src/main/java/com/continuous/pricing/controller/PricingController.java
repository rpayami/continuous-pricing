package com.continuous.pricing.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/pricing")
public class PricingController {
    @PostMapping
    Integer getAmount(@RequestBody PricingServiceDTO pricingServiceDTO) {
        return 3000;
    }
}
