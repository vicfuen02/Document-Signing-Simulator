package com.signingSimulator.signingSimulator.infrastructure.adapter.output.persistance.repository.jpa;

import com.signingSimulator.signingSimulator.application.ports.output.CertificateDAO;
import com.signingSimulator.signingSimulator.domain.Certificate;
import com.signingSimulator.signingSimulator.infrastructure.adapter.output.persistance.repository.mapper.CertificateServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CertificateJpaAdapter implements CertificateDAO {


    private CertificateJpaRepository certificateJpaRepository;

    private CertificateServiceMapper certificateServiceMapper;

    @Autowired
    public CertificateJpaAdapter(CertificateJpaRepository certificateJpaRepository, CertificateServiceMapper certificateServiceMapper) {
        this.certificateJpaRepository = certificateJpaRepository;
        this.certificateServiceMapper = certificateServiceMapper;
    }

    @Override
    public List<Certificate> getCertificateByUserId(String userId) {
        return certificateServiceMapper.toListDTO(certificateJpaRepository.getCertificateByUserId(userId));
    }

    @Override
    public Boolean uploadCertificate(String userId, Certificate certificate) {
        return certificateJpaRepository.uploadCertificate(userId, certificate);
    }
}
