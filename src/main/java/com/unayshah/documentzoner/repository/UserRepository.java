package com.unayshah.documentzoner.repository;

import java.util.Optional;

import com.unayshah.documentzoner.dao.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    @Query(value = "{username:?0, password:?1}")
    public Optional<User> checkUserCredentials(String username, String password);
}
