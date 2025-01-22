package com.continuous.usageestimate.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class PriceEstimate {
    @Id
    String id;

    @DBRef
    private UsageData usageData;
    private PricingPlan pricingPlan;
    private Integer amount;

    public PriceEstimate(String id, UsageData usageData, PricingPlan pricingPlan, Integer amount) {
        this.id = id;
        this.usageData = usageData;
        this.pricingPlan = pricingPlan;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public UsageData getUsageData() {
        return usageData;
    }

    public void setUsageData(UsageData usageData) {
        this.usageData = usageData;
    }

    public PricingPlan getPricingPlan() {
        return pricingPlan;
    }

    public void setPricingPlan(PricingPlan pricingPlan) {
        this.pricingPlan = pricingPlan;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
