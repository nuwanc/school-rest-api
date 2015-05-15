package com.app.school.service;


import com.app.school.dto.SchoolDTO;

import java.util.List;

public interface SchoolService {

    SchoolDTO create(SchoolDTO todo);

    SchoolDTO delete(String id);

    List<SchoolDTO> findAll();

    SchoolDTO findById(String id);

    SchoolDTO update(SchoolDTO todo);
}
