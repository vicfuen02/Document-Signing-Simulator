package com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.dto;

import com.signingSimulator.signingSimulator.infrastructure.adapter.output.persistance.entity.CertificateEntity;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
public class CertificateReqDTO {


    private Boolean success = false;

    @Id
    private String message;

    @ElementCollection
    private List<CertificateEntity> certificates = new ArrayList<>();

    public CertificateReqDTO() {
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

    public List<CertificateEntity> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<CertificateEntity> certificates) {
        this.certificates = certificates;
    }
}
