package com.jci.datafeed.datafeedservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class DataFeedServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataFeedServiceApplication.class, args);
	}

}
