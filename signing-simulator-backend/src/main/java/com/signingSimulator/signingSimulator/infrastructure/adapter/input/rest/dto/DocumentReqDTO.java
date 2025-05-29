package com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.dto;



public class DocumentReqDTO {

    private String document;

    private Long certificateId;
    private String certificatePassword;


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
}
