package com.signingSimulator.signingSimulator.domain;

public interface PostSingingContext {

    Document getDocument();
    Certificate getCertificate();

    Boolean getHandledSuccessfully();
    void setHandledSuccessfully(Boolean handleSuccessfully);

}
