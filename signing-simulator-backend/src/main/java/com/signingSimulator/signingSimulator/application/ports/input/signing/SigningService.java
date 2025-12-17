package com.signingSimulator.signingSimulator.application.ports.input.signing;

import com.signingSimulator.signingSimulator.domain.certificate.Certificate;
import com.signingSimulator.signingSimulator.domain.document.Document;

public interface SigningService {

    Document sign(Document document, Certificate certificate);
}
