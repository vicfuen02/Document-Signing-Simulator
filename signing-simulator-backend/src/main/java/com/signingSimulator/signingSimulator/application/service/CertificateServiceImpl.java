package com.signingSimulator.signingSimulator.application.service;

import com.signingSimulator.signingSimulator.application.ports.output.CertificateDAO;
import com.signingSimulator.signingSimulator.domain.Certificate;
import com.signingSimulator.signingSimulator.infrastructure.adapter.output.persistance.entity.CertificateEntity;
import com.signingSimulator.signingSimulator.infrastructure.adapter.output.persistance.repository.jpa.CertificateJpaRepository;
import com.signingSimulator.signingSimulator.application.ports.input.CertificateService;
import com.signingSimulator.signingSimulator.domain.exceptions.ServiceException;
import com.signingSimulator.signingSimulator.domain.exceptions.ServiceExceptionEnum;
import com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.dto.CertificateResDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CertificateServiceImpl implements CertificateService {

    Logger LOGGER = LoggerFactory.getLogger(CertificateServiceImpl.class);

    @Autowired
    private CertificateDAO certificateDAO;

    public CertificateResDTO getCertificateByUserId(String userId) {
        CertificateResDTO response = new CertificateResDTO();
        if (userId == null) {
            response.setCertificates(new ArrayList<>());
            return response;
        }

        List<Certificate> certificates = this.certificateDAO.getCertificateByUserId(userId);
        response.setCertificates(certificates);
        response.setSuccess(true);
        return response;
    }

    public CertificateResDTO uploadCertificate(String userId, Certificate certificate) throws ServiceException {

        CertificateResDTO response = new CertificateResDTO();
        if (certificate == null) {
            return response;
        }

        if (certificate.getPassword() == null || certificate.getPassword().isEmpty()) {
            throw new ServiceException(ServiceExceptionEnum.CERT_EMPTY_PASSWORD);
        }

        Boolean uploaded = this.certificateDAO.uploadCertificate(userId, certificate);
        if (!uploaded) {
            LOGGER.info("Error uploading document");
            throw new ServiceException(ServiceExceptionEnum.CERT_UPLOAD_ERROR);
        }

        List<Certificate> certificates = this.certificateDAO.getCertificateByUserId(userId);
        response.setCertificates(certificates);
        response.setSuccess(true);
        return response;
    }

}
