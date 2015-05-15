package com.app.school.service;

import com.app.school.dto.SchoolDTO;
import com.app.school.entity.School;
import com.app.school.exception.SchoolNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
final class MongoDBSchoolService implements SchoolService {

    private final SchoolRepository repository;

    @Autowired
    MongoDBSchoolService(SchoolRepository repository) {
        this.repository = repository;
    }

    @Override
    public SchoolDTO create(SchoolDTO todo) {
        School persisted = new School(todo.getEmailDomain(), todo.getAddress(), todo.getCode(), todo.getName());
        persisted = repository.save(persisted);
        return convertToDTO(persisted);
    }

    @Override
    public SchoolDTO delete(String id) {
        School deleted = findSchoolById(id);
        repository.delete(deleted);
        return convertToDTO(deleted);
    }

    @Override
    public List<SchoolDTO> findAll() {
        List<School> schools = repository.findAll();
        return convertToDTOs(schools);
    }


    @Override
    public SchoolDTO findById(String id) {
        School found = findSchoolById(id);
        return convertToDTO(found);
    }

    @Override
    public SchoolDTO update(SchoolDTO school) {
        School updated = findSchoolById(school.getId());

        updated.setCode(school.getCode());
        updated.setEmailDomain(school.getEmailDomain());
        updated.setName(school.getName());
        updated.setAddress(school.getAddress());

        updated = repository.save(updated);
        return convertToDTO(updated);
    }

    private School findSchoolById(String id) {
        Optional<School> result = repository.findOne(id);
        return result.orElseThrow(() -> new SchoolNotFoundException(id));
    }

    private List<SchoolDTO> convertToDTOs(List<School> schools) {
        return schools.stream()
                .map(this::convertToDTO)
                .collect(toList());
    }

    private SchoolDTO convertToDTO(School school) {
        SchoolDTO dto = new SchoolDTO();
        dto.setId(school.getId());
        dto.setAddress(school.getAddress());
        dto.setCode(school.getCode());
        dto.setName(school.getName());
        dto.setEmailDomain(school.getEmailDomain());

        return dto;
    }
}
