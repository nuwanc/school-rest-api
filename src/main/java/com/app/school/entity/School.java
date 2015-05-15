package com.app.school.entity;

import org.springframework.data.annotation.Id;

public class School {

	@Id
    private String id;

    private String name;

    private String code;

    private String address;

    private String emailDomain;

    public School(String emailDomain, String address, String code, String name) {
        this.emailDomain = emailDomain;
        this.address = address;
        this.code = code;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmailDomain() {
        return emailDomain;
    }

    public void setEmailDomain(String emailDomain) {
        this.emailDomain = emailDomain;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "School{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", address='" + address + '\'' +
                ", emailDomain='" + emailDomain + '\'' +
                '}';
    }
}