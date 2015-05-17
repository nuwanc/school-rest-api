package com.app.school.service;


import com.app.school.entity.School;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SchoolMongoRepository extends MongoRepository<School,String> {
    Optional<School> findById(String id);
}
