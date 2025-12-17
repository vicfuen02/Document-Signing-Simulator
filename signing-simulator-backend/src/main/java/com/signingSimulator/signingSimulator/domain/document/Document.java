package com.signingSimulator.signingSimulator.domain.document;

import java.io.Serializable;

public class Document   {

    private String document;

    private Boolean signed;

    private DocumentType type;

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

    public DocumentType getType() {
        return type;
    }

    public void setType(DocumentType type) {
        this.type = type;
    }
}
