package com.signingSimulator.signingSimulator.application.service;

import com.signingSimulator.signingSimulator.domain.Certificate;
import com.signingSimulator.signingSimulator.domain.Document;
import com.signingSimulator.signingSimulator.infrastructure.adapter.output.persistance.entity.CertificateEntity;
import com.signingSimulator.signingSimulator.infrastructure.adapter.output.persistance.entity.DocumentEntity;
import com.signingSimulator.signingSimulator.application.ports.input.CertificateService;
import com.signingSimulator.signingSimulator.application.ports.input.SigningService;
import com.signingSimulator.signingSimulator.domain.exceptions.ServiceException;
import com.signingSimulator.signingSimulator.domain.exceptions.ServiceExceptionEnum;
import com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.dto.CertificateResDTO;
import com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.dto.SigningResDTO;
import com.signingSimulator.signingSimulator.common.interceptors.PasswordsUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SigningServiceImpl implements SigningService {

    Logger LOGGER = LoggerFactory.getLogger(SigningServiceImpl.class);

    private static String SIGN = "#documentSigned:)#";

    @Autowired
    private CertificateService certificateService;

    @Autowired
    private PasswordsUtils passwordsUtils;

    public SigningResDTO signDocument(String userId, Document document) throws ServiceException {

        CertificateResDTO certificatesResponse = this.certificateService.getCertificateByUserId(userId);
        List<Certificate> certificates = certificatesResponse.getCertificates();

        if (certificates.isEmpty()) {
            throw new ServiceException(ServiceExceptionEnum.CERTIFICATES_EMPTY);
        }

        Certificate certificate = certificates.get(0);

        if (!certificate.getPassword().equals(this.passwordsUtils.encryptPass(document.getCertificatePassword()))) {
            throw new ServiceException(ServiceExceptionEnum.WRONG_CERTIFICATE_PASSWORD);
        }

        SigningResDTO response = new SigningResDTO();
        response.setDocument(this.sign(document));

        return response;
    }

    private DocumentEntity sign(Document document) {
        return new DocumentEntity()
                .setSigned(true)
                .setDocumentBytes(SIGN + document.getDocumentBytes())
                .build();
    }

}
