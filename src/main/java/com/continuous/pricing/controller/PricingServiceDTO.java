package com.continuous.pricing.controller;

import com.continuous.usageestimate.model.PricingPlan;
import com.continuous.usageestimate.model.UsageData;

public class PricingServiceDTO {
    private UsageData usageData;
    private PricingPlan pricingPlan;

    public PricingServiceDTO(UsageData usageData, PricingPlan pricingPlan) {
        this.usageData = usageData;
        this.pricingPlan = pricingPlan;
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

}
