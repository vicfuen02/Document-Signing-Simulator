package com.signingSimulator.signingSimulator.infrastructure.adapter.output.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserEntity {

    @Id
    @Column(name="USER_ID")
    private String id;

    @Column(name="USER_USERNAME")
    private String user;

    @Column(name="USER_PASSWORD")
    private String password;

    @Column(name="USER_NAME")
    private String name;

    @Column(name="USER_SURNAME")
    private String surname;

    @Column(name="USER_EMAIL")
    private String email;


    public UserEntity() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "UserModel{" +
                "id='" + id + '\'' +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
