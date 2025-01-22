package com.continuous.usageestimate.controller;

import com.continuous.pricing.controller.PricingServiceDTO;
import com.continuous.pricing.controller.PricingServiceRestClient;
import com.continuous.usageestimate.model.PriceEstimate;
import com.continuous.usageestimate.model.PricingPlan;
import com.continuous.usageestimate.model.UsageData;
import com.continuous.usageestimate.repository.PriceEstimateRepository;
import com.continuous.usageestimate.repository.UsageDataRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/usage-estimates")
public class UsageEstimateController {

    private final UsageDataRepository usageDataRepository;
    private final PricingServiceRestClient pricingServiceRestClient;
    private final PriceEstimateRepository priceEstimateRepository;

    public UsageEstimateController(UsageDataRepository usageDataRepository, PricingServiceRestClient pricingServiceRestClient, PriceEstimateRepository priceEstimateRepository) {
        this.usageDataRepository = usageDataRepository;
        this.pricingServiceRestClient = pricingServiceRestClient;
        this.priceEstimateRepository = priceEstimateRepository;
    }

    @GetMapping
    public List<PriceEstimate> get(@RequestBody UsageEstimateQuery query) {
        List<PriceEstimate> result = new ArrayList<>();

        UsageData exampleUsageData = new UsageData(null, query.getResourceType(), null, query.getAttributes(), query.getStartDate(), query.getEndDate());
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreNullValues();
        List<UsageData> usageDataList = usageDataRepository.findAll(Example.of(exampleUsageData, matcher));

        for (UsageData usageData : usageDataList) {
            PriceEstimate examplePriceEstimate = new PriceEstimate(null, usageData, query.getPricingPlan(), null);
            result.addAll(priceEstimateRepository.findAll(Example.of(examplePriceEstimate, matcher)));
        }

        return result;
    }

    private String create(@Valid UsageData usageData) {
        usageDataRepository.save(usageData);

        for (PricingPlan pricingPlan : PricingPlan.values()) {
            PricingServiceDTO pricingServiceDTO = new PricingServiceDTO(usageData, PricingPlan.PAY_AS_YOU_GO);
            Integer amount = pricingServiceRestClient.getAmount(pricingServiceDTO);
            PriceEstimate priceEstimate = new PriceEstimate(null, usageData, pricingPlan, amount);
            priceEstimateRepository.save(priceEstimate);
        }
        return usageData.getId();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    List<String> create(@RequestBody @Valid List<UsageData> usageDataList) {
        List<String> result = new ArrayList<>();
        for (UsageData usageData : usageDataList) {
            result.add(create(usageData));
        }
        return result;
    }

}