package com.jci.datafeed.datafeedservice.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document("datafeed")
@Getter @Setter
public class DataFeedMapping {

    @Id
    public String id;
    public String tenantId;
    public String tenantName;
    public String subscriptionId;
    public String erCollectionId;
    public String feedType = "OBC";
    public String description;
    public String feedReferenceId;
    public List<String> eventTypes;
    public List<String> connectorGroups;

}
