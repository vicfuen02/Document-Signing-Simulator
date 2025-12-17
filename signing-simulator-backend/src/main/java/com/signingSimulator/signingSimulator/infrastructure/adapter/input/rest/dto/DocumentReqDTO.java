package com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.dto;


import com.signingSimulator.signingSimulator.domain.document.DocumentType;

public class DocumentReqDTO {

    private String document;

    private Long certificateId;
    private String certificatePassword;
    private DocumentType type;


    public DocumentReqDTO() {
    }


    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getCertificatePassword() {
        return certificatePassword;
    }

    public void setCertificatePassword(String certificatePassword) {
        this.certificatePassword = certificatePassword;
    }


    public Long getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(Long certificateId) {
        this.certificateId = certificateId;
    }

    public DocumentType getType() {
        return type;
    }

    public void setType(DocumentType type) {
        this.type = type;
    }
}
