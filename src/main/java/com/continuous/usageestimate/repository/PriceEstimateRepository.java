package com.continuous.usageestimate.repository;

import com.continuous.usageestimate.model.PriceEstimate;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PriceEstimateRepository extends MongoRepository<PriceEstimate, String> {
}
