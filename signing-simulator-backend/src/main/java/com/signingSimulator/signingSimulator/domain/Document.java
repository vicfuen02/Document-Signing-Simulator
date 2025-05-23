package com.signingSimulator.signingSimulator.domain;

public class Document {

    private String documentBytes;

    private Boolean signed;

    private String certificatePassword;

    public String getDocumentBytes() {
        return documentBytes;
    }

    public void setDocumentBytes(String documentBytes) {
        this.documentBytes = documentBytes;
    }

    public Boolean getSigned() {
        return signed;
    }

    public void setSigned(Boolean signed) {
        this.signed = signed;
    }

    public String getCertificatePassword() {
        return certificatePassword;
    }

    public void setCertificatePassword(String certificatePassword) {
        this.certificatePassword = certificatePassword;
    }
}
