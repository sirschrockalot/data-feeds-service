package com.jci.datafeed.datafeedservice.manager;

public interface DataFeedsManager {
    Boolean dataFeedExists(String tenantId, String erCollectionId);
}
