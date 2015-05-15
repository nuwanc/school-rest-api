package com.app.school.service;

import com.app.school.entity.School;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;


public interface SchoolRepository extends Repository<School,String>{
    void delete(School deleted);

    List<School> findAll();

    Optional<School> findOne(String id);

    School save(School saved);
}
