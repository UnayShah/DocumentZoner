package com.unayshah.documentzoner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@EnableAutoConfiguration
@SpringBootApplication
public class DocumentzonerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocumentzonerApplication.class, args);
	}

}
