package com.signingSimulator.signingSimulator.domain;

import com.signingSimulator.signingSimulator.infrastructure.adapter.output.persistance.entity.UserEntity;

public class Login {

    private String token;

    private Boolean success = false;

    private String message;

    private UserEntity user;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
