package com.signingSimulator.signingSimulator.domain;

import com.signingSimulator.signingSimulator.infrastructure.adapter.output.persistance.entity.DocumentEntity;

public class Signing {

    private Boolean success = false;

    private String message;

    private DocumentEntity document;


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
