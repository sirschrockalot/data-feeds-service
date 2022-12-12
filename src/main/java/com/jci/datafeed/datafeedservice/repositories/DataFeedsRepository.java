package com.jci.datafeed.datafeedservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jci.datafeed.datafeedservice.model.DataFeedMapping;

public interface DataFeedsRepository extends MongoRepository<DataFeedMapping, String> {
    findByTenantIdAndErCollectionId(String tenantId, String erCollectionId)
    
}
