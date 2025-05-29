package com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.dto;

import com.signingSimulator.signingSimulator.domain.User;


public class LoginResDTO {


    private String token;

    private Boolean success = false;

    private String message;


    private User user;



    public LoginResDTO() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
