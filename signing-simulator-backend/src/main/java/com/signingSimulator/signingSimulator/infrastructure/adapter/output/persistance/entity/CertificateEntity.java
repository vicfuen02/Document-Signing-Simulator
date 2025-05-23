package com.signingSimulator.signingSimulator.infrastructure.adapter.output.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class CertificateEntity {

    @Id
    @Column(name="CERT_ID")
    private String id;

    @Column(name="CERT_NAME")
    private String name;
    @Column(name="CERT_DOCUMENT")
    private String certificate;
    @Column(name="CERT_PASSWORD")
    private String password;
    @Column(name="USER_ID")
    private String userId;
    @Column(name="CERT_DATEFROM")
    private Date dateFrom;
    @Column(name="CERT_DATETO")
    private Date dateTo;

    public CertificateEntity() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }
}
