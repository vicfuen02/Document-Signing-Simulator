package com.signingSimulator.signingSimulator.infrastructure.adapter.output.persistance.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class DocumentEntity {

    @Id
    private String documentBytes;

    private Boolean signed;

    private String certificatePassword;


    public DocumentEntity() {
    }

    private DocumentEntity(String documentBytes, Boolean signed, String certificatePassword) {
        this.documentBytes = documentBytes;
        this.signed = signed;
        this.certificatePassword = certificatePassword;
    }

    public DocumentEntity build() {
        return new DocumentEntity(documentBytes, signed, certificatePassword);
    }

    public String getDocumentBytes() {
        return documentBytes;
    }

    public DocumentEntity setDocumentBytes(String documentBytes) {
        this.documentBytes = documentBytes;
        return this;
    }

    public Boolean getSigned() {
        return signed;
    }

    public DocumentEntity setSigned(Boolean signed) {
        this.signed = signed;
        return this;
    }

    public String getCertificatePassword() {
        return certificatePassword;
    }

    public DocumentEntity setCertificatePassword(String certificatePassword) {
        this.certificatePassword = certificatePassword;
        return this;
    }


}
