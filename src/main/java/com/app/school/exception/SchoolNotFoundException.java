package com.app.school.exception;


public class SchoolNotFoundException extends RuntimeException {

    public SchoolNotFoundException(String id) {
        super(String.format("No school entry found with id: <%s>", id));
    }

}
