package com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.dto;



public class DocumentReqDTO {

    private String documentBytes;

    private Boolean signed;

    private String certificatePassword;


    public DocumentReqDTO() {
    }

    private DocumentReqDTO(String documentBytes, Boolean signed, String certificatePassword) {
        this.documentBytes = documentBytes;
        this.signed = signed;
        this.certificatePassword = certificatePassword;
    }

    public DocumentReqDTO build() {
        return new DocumentReqDTO(documentBytes, signed, certificatePassword);
    }

    public String getDocumentBytes() {
        return documentBytes;
    }

    public DocumentReqDTO setDocumentBytes(String documentBytes) {
        this.documentBytes = documentBytes;
        return this;
    }

    public Boolean getSigned() {
        return signed;
    }

    public DocumentReqDTO setSigned(Boolean signed) {
        this.signed = signed;
        return this;
    }

    public String getCertificatePassword() {
        return certificatePassword;
    }

    public DocumentReqDTO setCertificatePassword(String certificatePassword) {
        this.certificatePassword = certificatePassword;
        return this;
    }


}
