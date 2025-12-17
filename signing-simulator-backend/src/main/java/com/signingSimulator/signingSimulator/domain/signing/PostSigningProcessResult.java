package com.signingSimulator.signingSimulator.domain.signing;

import com.signingSimulator.signingSimulator.domain.certificate.Certificate;
import com.signingSimulator.signingSimulator.domain.document.Document;

public class PostSigningProcessResult implements PostSingingContext {


    private final Document document;
    private final Certificate certificate;

    private Boolean handledSuccessfully = false;


    public PostSigningProcessResult(Document document, Certificate certificate) {
        this.document = document;
        this.certificate = certificate;
    }


    @Override
    public Document getDocument() {
        return document;
    }


    @Override
    public Boolean getHandledSuccessfully() {
        return this.handledSuccessfully;
    }


    @Override
    public void setHandledSuccessfully(Boolean handledSuccessfully) {
        this.handledSuccessfully = handledSuccessfully;
    }

    public Certificate getCertificate() {
        return certificate;
    }
}
