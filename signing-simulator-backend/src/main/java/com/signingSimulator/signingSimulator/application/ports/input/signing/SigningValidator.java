package com.signingSimulator.signingSimulator.application.ports.input.signing;

import com.signingSimulator.signingSimulator.domain.Certificate;
import com.signingSimulator.signingSimulator.domain.SigningValidResult;

public interface SigningValidator {

    SigningValidResult apply(Certificate certificate);

}
