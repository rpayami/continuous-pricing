package com.continuous.usageestimate.repository;


import java.util.Date;
import java.util.List;
import java.util.Map;

import com.continuous.usageestimate.model.ResourceType;
import com.continuous.usageestimate.model.UsageData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsageDataRepository extends MongoRepository<UsageData, String> {
}
