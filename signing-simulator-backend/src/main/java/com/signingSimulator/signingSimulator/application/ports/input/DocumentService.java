package com.signingSimulator.signingSimulator.application.ports.input;

import com.signingSimulator.signingSimulator.domain.certificate.Certificate;
import com.signingSimulator.signingSimulator.domain.document.Document;

public interface DocumentService {

    Document signDocument(Document document, Certificate certificate);
}
