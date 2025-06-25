package com.signingSimulator.signingSimulator.application.ports.input.signing;

import com.signingSimulator.signingSimulator.domain.Certificate;
import com.signingSimulator.signingSimulator.domain.Document;

public interface SigningService {

    Document sign(Document document, Certificate certificate);
}
