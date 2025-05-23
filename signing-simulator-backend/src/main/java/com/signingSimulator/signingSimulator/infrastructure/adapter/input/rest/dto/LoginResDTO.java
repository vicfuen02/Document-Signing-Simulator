package com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.dto;

import com.signingSimulator.signingSimulator.infrastructure.adapter.output.persistance.entity.UserEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class LoginResDTO {

    @Id
    private String token;

    private Boolean success = false;

    private String message;

    @OneToOne
    private UserEntity user;



    public LoginResDTO() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
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
