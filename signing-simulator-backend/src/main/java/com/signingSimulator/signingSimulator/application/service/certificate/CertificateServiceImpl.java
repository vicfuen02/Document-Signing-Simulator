package com.signingSimulator.signingSimulator.application.service.certificate;

import com.signingSimulator.signingSimulator.application.ports.input.UserService;
import com.signingSimulator.signingSimulator.application.ports.output.dao.CertificateDAO;
import com.signingSimulator.signingSimulator.domain.certificate.Certificate;
import com.signingSimulator.signingSimulator.application.ports.input.certificate.CertificateService;
import com.signingSimulator.signingSimulator.domain.User;
import com.signingSimulator.signingSimulator.domain.exceptions.SigningSimulatorServiceException;
import com.signingSimulator.signingSimulator.domain.exceptions.SigningSimulatorServiceExceptionEnum;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificateServiceImpl implements CertificateService {

    Logger LOGGER = LoggerFactory.getLogger(CertificateServiceImpl.class);


    private CertificateDAO certificateDAO;
    private UserService userService;


    @Autowired
    public CertificateServiceImpl(CertificateDAO certificateDAO, UserService userService) {
        this.certificateDAO = certificateDAO;
        this.userService = userService;
    }

    public List<Certificate> getCertificatesByUserId(Long userId) {
        if (userId == null) {
            return null;
        }

        List<Certificate> certificates = this.certificateDAO.getCertificatesByUserId(userId);
        return certificates;
    }

    public Certificate getCertificateById(Long id) {
        return this.certificateDAO.getCertificateById(id);
    }


    @Transactional
    public List<Certificate> uploadCertificate(Certificate certificate) {

        if (certificate == null) {
            return null;
        }

        if (certificate.getPassword() == null || certificate.getPassword().isEmpty()) {
            throw new SigningSimulatorServiceException(SigningSimulatorServiceExceptionEnum.CERT_EMPTY_PASSWORD);
        }

        User user = this.userService.getById(certificate.getUser().getId());
        certificate.setUser(user);

        Certificate cert = this.certificateDAO.uploadCertificate(certificate);
        if (cert == null) {
            throw new SigningSimulatorServiceException(SigningSimulatorServiceExceptionEnum.CERT_UPLOAD_ERROR);
        }

        List<Certificate> certificates = this.certificateDAO.getCertificatesByUserId(cert.getUser().getId());

        return certificates;
    }



}
