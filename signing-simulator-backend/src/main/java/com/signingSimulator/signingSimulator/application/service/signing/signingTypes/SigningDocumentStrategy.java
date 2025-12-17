package com.signingSimulator.signingSimulator.application.service.signing.signingTypes;

import com.signingSimulator.signingSimulator.domain.certificate.Certificate;
import com.signingSimulator.signingSimulator.domain.document.Document;

public interface SigningDocumentStrategy {

    Document sign(Document document, Certificate certificate);
    String getType();

}
