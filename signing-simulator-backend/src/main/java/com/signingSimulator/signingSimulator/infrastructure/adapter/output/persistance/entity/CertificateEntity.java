package com.signingSimulator.signingSimulator.infrastructure.adapter.output.persistance.entity;

import jakarta.persistence.*;

import java.util.Date;

@Table(name="SDS_CERTIFICATE")
@Entity
public class CertificateEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq_certificate_id_gen")
    @SequenceGenerator(name="seq_certificate_id_gen", sequenceName="SEQ_CERTIFICATE_ID", initialValue = 1000, allocationSize = 2)
    private Long id;

    @Column(name="CERT_NAME")
    private String name;
    @Column(name="CERT_DOCUMENT")
    private String certificate;
    @Column(name="CERT_PASSWORD")
    private String password;
    @Column(name="CERT_DATEFROM")
    private Date dateFrom;
    @Column(name="CERT_DATETO")
    private Date dateTo;

    @JoinColumn(name="user_id", nullable=false, referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.MERGE, optional=false)
    private UserEntity user;

    public CertificateEntity() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
