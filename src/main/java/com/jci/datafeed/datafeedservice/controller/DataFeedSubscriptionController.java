package com.jci.datafeed.datafeedservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/datafeedSubscription", produces = { "application/json" })
public class DataFeedSubscriptionController {

    @GetMapping()
    public String searchDataFeeds(@RequestParam(value = "accountSubscriptionId", required = true) String tenantId,
    @RequestParam(value = "dataflowId", required = true) String erCollectionId){
            
        return "";
    }
    
}
