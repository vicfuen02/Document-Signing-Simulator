package com.signingSimulator.signingSimulator.application.service;

import com.signingSimulator.signingSimulator.application.ports.input.DocumentService;
import com.signingSimulator.signingSimulator.domain.Certificate;
import com.signingSimulator.signingSimulator.domain.Document;
import com.signingSimulator.signingSimulator.application.ports.input.certificate.CertificateService;
import com.signingSimulator.signingSimulator.application.ports.input.signing.SigningService;
import com.signingSimulator.signingSimulator.domain.exceptions.SigningSimulatorServiceException;
import com.signingSimulator.signingSimulator.domain.exceptions.SigningSimulatorServiceExceptionEnum;
import com.signingSimulator.signingSimulator.common.interceptors.PasswordsUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DocumentServiceImpl implements DocumentService {

    Logger LOGGER = LoggerFactory.getLogger(DocumentServiceImpl.class);


    private CertificateService certificateService;
    private SigningService signingService;

    private PasswordsUtils passwordsUtils;

    @Autowired
    public DocumentServiceImpl(CertificateService certificateService, PasswordsUtils passwordsUtils, SigningService signingService) {
        this.certificateService = certificateService;
        this.passwordsUtils = passwordsUtils;
        this.signingService = signingService;
    }

    public Document signDocument(Document document, Certificate certificate) {

        Certificate cert = this.certificateService.getCertificateById(certificate.getId());
        return signingService.sign(document, cert);
    }



}
