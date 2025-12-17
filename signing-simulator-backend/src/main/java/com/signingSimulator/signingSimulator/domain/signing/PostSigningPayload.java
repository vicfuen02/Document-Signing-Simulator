package com.signingSimulator.signingSimulator.domain.signing;


import com.signingSimulator.signingSimulator.domain.event.EventPayload;
import com.signingSimulator.signingSimulator.domain.certificate.Certificate;
import com.signingSimulator.signingSimulator.domain.document.Document;


public class PostSigningPayload implements EventPayload {


    private Document document;
    private Long certificateId;
    private Certificate certificate;


    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Long getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(Long certificateId) {
        this.certificateId = certificateId;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }
}
