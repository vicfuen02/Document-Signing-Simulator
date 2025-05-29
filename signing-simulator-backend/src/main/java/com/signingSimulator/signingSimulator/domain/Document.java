package com.signingSimulator.signingSimulator.domain;

public class Document {

    private String document;

    private Boolean signed;

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Boolean getSigned() {
        return signed;
    }

    public void setSigned(Boolean signed) {
        this.signed = signed;
    }
}
