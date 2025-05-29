package com.signingSimulator.signingSimulator.infrastructure.adapter.output.persistance.entity;

import jakarta.persistence.*;

@Table(name="SDS_USER")
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq_user_id_gen")
    @SequenceGenerator(name="seq_user_id_gen", sequenceName="SEQ_USER_ID", initialValue = 1000, allocationSize = 2)
    private Long id;

    @Column(name="USER_NAME")
    private String name;

    @Column(name="USER_PASSWORD")
    private String password;


    public UserEntity() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
