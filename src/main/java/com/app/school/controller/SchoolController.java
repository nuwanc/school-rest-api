package com.app.school.controller;

import com.app.school.dto.SchoolDTO;
import com.app.school.exception.SchoolNotFoundException;
import com.app.school.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/school")
final class SchoolController {
    private final SchoolService service;

    @Autowired
    SchoolController(SchoolService service){
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    SchoolDTO create(@RequestBody SchoolDTO schoolEntry) {
        return service.create(schoolEntry);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    SchoolDTO delete(@PathVariable("id") String id) {
        return service.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    List<SchoolDTO> findAll() {
        return service.findAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    SchoolDTO findById(@PathVariable("id") String id) {
        return service.findById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    SchoolDTO update(@RequestBody SchoolDTO schoolEntry) {
        return service.update(schoolEntry);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleTodoNotFound(SchoolNotFoundException ex) {
    }
}
