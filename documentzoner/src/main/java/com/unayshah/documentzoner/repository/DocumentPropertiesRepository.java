package com.unayshah.documentzoner.repository;

import com.unayshah.documentzoner.dao.DocumentProperties;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentPropertiesRepository extends MongoRepository<DocumentProperties, String> {
}
