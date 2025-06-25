package com.signingSimulator.signingSimulator.application.service.signing.signingTypes;

import com.signingSimulator.signingSimulator.domain.Certificate;
import com.signingSimulator.signingSimulator.domain.Document;

public interface SigningDocumentStrategy {

    Document sign(Document document, Certificate certificate);
    String getType();

}
