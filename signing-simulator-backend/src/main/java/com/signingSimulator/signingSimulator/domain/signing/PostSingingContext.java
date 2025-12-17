package com.signingSimulator.signingSimulator.domain.signing;

import com.signingSimulator.signingSimulator.domain.certificate.Certificate;
import com.signingSimulator.signingSimulator.domain.document.Document;

public interface PostSingingContext {

    Document getDocument();
    Certificate getCertificate();

    Boolean getHandledSuccessfully();
    void setHandledSuccessfully(Boolean handleSuccessfully);

}
