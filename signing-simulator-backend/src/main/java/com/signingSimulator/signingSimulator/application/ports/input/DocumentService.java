package com.signingSimulator.signingSimulator.application.ports.input;

import com.signingSimulator.signingSimulator.domain.Certificate;
import com.signingSimulator.signingSimulator.domain.Document;

public interface DocumentService {

    Document signDocument(Document document, Certificate certificate);
}
