package com.continuous.usageestimate.controller;

import com.continuous.usageestimate.model.PricingPlan;
import com.continuous.usageestimate.model.ResourceType;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UsageEstimateQuery {

    private ResourceType resourceType;
    private Map<String, String> attributes = new HashMap<>();

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date startDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    private PricingPlan pricingPlan;

    public UsageEstimateQuery(ResourceType resourceType, Integer quantity, Date startDate, Date endDate, Map<String, String> attributes, PricingPlan pricingPlan) {
        this.resourceType = resourceType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.attributes = attributes;
        this.pricingPlan = pricingPlan;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public String getAttribute(String attributeName) {
        return attributes.get(attributeName);
    }

    public String setAttribute(String attributeName, String attributeValue) {
        return attributes.put(attributeName, attributeValue);
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public PricingPlan getPricingPlan() {
        return pricingPlan;
    }

    public void setPricingPlan(PricingPlan pricingPlan) {
        this.pricingPlan = pricingPlan;
    }

}
