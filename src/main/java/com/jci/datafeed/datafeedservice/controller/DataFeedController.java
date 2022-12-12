package com.jci.datafeed.datafeedservice.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jci.datafeed.datafeedservice.manager.DataFeedsManager;
import com.jci.datafeed.datafeedservice.manager.DataFeedsManagerImpl;
import com.jci.datafeed.datafeedservice.model.DataFeedMapping;
import com.jci.datafeed.datafeedservice.repositories.DataFeedsRepository;
import com.jci.datafeed.datafeedservice.util.GsonUtil;

@RestController
@RequestMapping(value = "/data-feeds", produces = { "application/json" })
@CacheConfig(cacheNames={"datafeeds"})
public class DataFeedController {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DataFeedsRepository repo;

    @Autowired
    private DataFeedsManager manager;

    @GetMapping("/{id}")
    @Cacheable
    public String fetchDataFeed(@PathVariable(value = "id", required = true) String id){
        Optional<DataFeedMapping> dataFeedResponse = repo.findById(id);

        return GsonUtil.getGson().toJson(dataFeedResponse.get());
    }

    @GetMapping()
    @Cacheable
    public String searchDataFeeds(@RequestParam(value = "tenantId", required = true) String tenantId,
    @RequestParam(value = "erCollectionId", required = true) String erCollectionId){
        return "";
    }

    @PostMapping("/create")
    public String createDataFeed(HttpServletResponse response, HttpEntity<String> feedback) throws IOException{

        try {
			return GsonUtil.getGson()
					.toJson(repo.save(GsonUtil.getGson().fromJson(feedback.getBody(), DataFeedMapping.class)));
		} catch (OptimisticLockingFailureException e) {
			response.setStatus(HttpServletResponse.SC_CONFLICT);
			LOG.error("Failed to save feedback", e);
			return e.toString();
		}

    }

    @DeleteMapping("/delete")
    public void deleteDataFeed(@PathVariable(value = "id", required = true) String id){
        repo.deleteById(id);
    }
    
}
