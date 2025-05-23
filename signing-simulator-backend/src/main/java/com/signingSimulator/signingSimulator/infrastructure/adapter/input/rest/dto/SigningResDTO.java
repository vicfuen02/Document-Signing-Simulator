package com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.dto;

import com.signingSimulator.signingSimulator.infrastructure.adapter.output.persistance.entity.DocumentEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class SigningResDTO {


    private Boolean success = false;

    @Id
    private String message;

    @OneToOne
    private DocumentEntity document;

    public SigningResDTO() {
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

    public DocumentEntity getDocument() {
        return document;
    }

    public void setDocument(DocumentEntity document) {
        this.document = document;
    }
}
