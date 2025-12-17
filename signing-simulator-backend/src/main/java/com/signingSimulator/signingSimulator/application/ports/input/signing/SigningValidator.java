package com.signingSimulator.signingSimulator.application.ports.input.signing;

import com.signingSimulator.signingSimulator.domain.certificate.Certificate;
import com.signingSimulator.signingSimulator.domain.signing.SigningValidResult;

public interface SigningValidator {

    SigningValidResult apply(Certificate certificate);

}
