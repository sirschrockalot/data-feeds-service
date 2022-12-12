package com.jci.datafeed.datafeedservice.model;

import lombok.Setter;

@Getter @Setter
public class DataFeedRequest {

    public String tenantId;
    public String tenantShortName;
    public String erCollectionId;
    public String feedType = "OBC";
    public String description = "OBT Subscription";
    public List<String> eventTypes;
    public List<String> connectorGroups;
    
}
