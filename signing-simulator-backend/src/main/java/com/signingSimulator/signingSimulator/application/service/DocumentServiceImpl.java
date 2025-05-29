package com.signingSimulator.signingSimulator.application.service;

import com.signingSimulator.signingSimulator.domain.Certificate;
import com.signingSimulator.signingSimulator.domain.Document;
import com.signingSimulator.signingSimulator.application.ports.input.CertificateService;
import com.signingSimulator.signingSimulator.application.ports.input.SigningService;
import com.signingSimulator.signingSimulator.domain.exceptions.SigningSimulatorServiceException;
import com.signingSimulator.signingSimulator.domain.exceptions.SigningSimulatorServiceExceptionEnum;
import com.signingSimulator.signingSimulator.common.interceptors.PasswordsUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DocumentServiceImpl implements SigningService {

    Logger LOGGER = LoggerFactory.getLogger(DocumentServiceImpl.class);


    private CertificateService certificateService;

    private PasswordsUtils passwordsUtils;

    @Autowired
    public DocumentServiceImpl(CertificateService certificateService, PasswordsUtils passwordsUtils) {
        this.certificateService = certificateService;
        this.passwordsUtils = passwordsUtils;
    }

    public Document signDocument(Document document, Certificate certificate) {

        Certificate cert = this.certificateService.getCertificateById(certificate.getId());

        Boolean valid = this.certificateService.checkCertificateCredentials(cert);
        if (!valid) {
            throw new SigningSimulatorServiceException(SigningSimulatorServiceExceptionEnum.WRONG_CERTIFICATE_PASSWORD);
        }

        return this.sign(document, cert);
    }

    private Document sign(Document document, Certificate certificate) {

        String signature = "Singed by: " + certificate.getName() + ". ";

        Document doc = new Document();
        doc.setSigned(true);
        doc.setDocument(signature + document.getDocument());
        return doc;
    }

}
