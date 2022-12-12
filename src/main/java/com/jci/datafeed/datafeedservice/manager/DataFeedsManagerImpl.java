package com.jci.datafeed.datafeedservice.manager;

@Service
public class DataFeedsManagerImpl implements DataFeedsManager {

    @Autowired
    private DataFeedsRepository repo;

    /*
     * Validate if an existing DataFeed mapping already exists return true or false
     */
    @Override
    public Boolean dataFeedExists(String tenantId, String erCollectionId) {
        Optional<DataFeedMapping> dataFeedResponse = repo.findByTenantIdAndErCollectionId(tenantId, erCollectionId);

        return dataFeedResponse.isPresent();
    }
}
