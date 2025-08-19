package com.signingSimulator.signingSimulator.application.service.signing.validator;

import com.signingSimulator.signingSimulator.application.ports.input.certificate.CertificateService;
import com.signingSimulator.signingSimulator.application.ports.input.signing.SigningValidator;
import com.signingSimulator.signingSimulator.common.interceptors.PasswordsUtils;
import com.signingSimulator.signingSimulator.domain.certificate.Certificate;
import com.signingSimulator.signingSimulator.domain.signing.SigningValidResult;
import org.springframework.stereotype.Component;

@Component
public abstract class SigningValidatorAbstract implements SigningValidator {


    private CertificateService certificateService;

    private PasswordsUtils passwordsUtils;


    public SigningValidatorAbstract(CertificateService certificateService, PasswordsUtils passwordsUtils) {
        this.certificateService = certificateService;
        this.passwordsUtils = passwordsUtils;
    }

    public SigningValidResult apply(Certificate certificate) {

        SigningValidResult valid = new SigningValidResult();
        valid.setValid(this.checkCertificateCredentials(certificate));

        valid.setValid(valid.getValid() && this.specificDocumentValidation(certificate));

        return valid;
    }

    private Boolean checkCertificateCredentials(Certificate certificate) {

        Certificate cert = certificateService.getCertificateById(certificate.getId());
        return cert.getPassword().equals(this.passwordsUtils.encryptPass(certificate.getPassword()));
    }

    protected abstract Boolean specificDocumentValidation(Certificate certificate);




}
