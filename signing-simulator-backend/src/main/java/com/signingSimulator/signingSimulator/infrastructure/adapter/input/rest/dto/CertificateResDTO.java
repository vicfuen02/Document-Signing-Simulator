package com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.dto;

import com.signingSimulator.signingSimulator.domain.Certificate;
import com.signingSimulator.signingSimulator.infrastructure.adapter.output.persistance.entity.CertificateEntity;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
public class CertificateResDTO {


    private Boolean success = false;

    @Id
    private String message;

    @ElementCollection
    private List<Certificate> certificates = new ArrayList<>();

    public CertificateResDTO() {
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

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }
}
