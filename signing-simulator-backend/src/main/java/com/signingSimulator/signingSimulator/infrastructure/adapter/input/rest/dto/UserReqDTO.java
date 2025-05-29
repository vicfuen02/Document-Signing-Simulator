package com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.dto;


public class UserReqDTO {


    private Long id;

    private String password;

    private String name;


    public UserReqDTO() {
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
