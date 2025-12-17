package com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.dto;



import java.util.Date;

public class CertificateResDTO {


    private Long id;

    private String name;
    private String certificate;
    private UserResDTO user;
    private Date dateFrom;
    private Date dateTo;


    public CertificateResDTO() {
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

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public UserResDTO getUser() {
        return user;
    }

    public void setUser(UserResDTO user) {
        this.user = user;
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
