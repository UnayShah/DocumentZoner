package com.unayshah.documentzoner.repository;

import java.util.List;
import java.util.Optional;

import com.unayshah.documentzoner.dao.DocumentProperties;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentPropertiesRepository extends MongoRepository<DocumentProperties, String> {

    @Query(value = "{_id:?0}", fields = "{ _id:1,   \"document.actualDocumentName\": 1, \"document.documentName\": 1, \"document.extension\": 1}")
    public Optional<DocumentProperties> findByIdShort(String id);

    @Query(value = "{}", fields = "{ _id:1,   \"document.actualDocumentName\": 1, \"document.documentName\": 1, \"document.extension\": 1}")
    public List<DocumentProperties> findAllShort();
}
