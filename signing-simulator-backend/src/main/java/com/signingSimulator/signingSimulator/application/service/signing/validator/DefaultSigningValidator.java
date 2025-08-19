package com.signingSimulator.signingSimulator.application.service.signing.validator;

import com.signingSimulator.signingSimulator.application.ports.input.certificate.CertificateService;
import com.signingSimulator.signingSimulator.common.interceptors.PasswordsUtils;
import com.signingSimulator.signingSimulator.domain.certificate.Certificate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultSigningValidator extends SigningValidatorAbstract {

    @Autowired
    public DefaultSigningValidator(CertificateService certificateService, PasswordsUtils passwordsUtils) {
        super(certificateService, passwordsUtils);
    }

    @Override
    protected Boolean specificDocumentValidation(Certificate certificate) {
        return true;
    }


}
