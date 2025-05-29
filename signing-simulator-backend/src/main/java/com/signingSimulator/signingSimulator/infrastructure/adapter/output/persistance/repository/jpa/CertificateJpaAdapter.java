package com.signingSimulator.signingSimulator.infrastructure.adapter.output.persistance.repository.jpa;

import com.signingSimulator.signingSimulator.application.ports.output.CertificateDAO;
import com.signingSimulator.signingSimulator.domain.Certificate;
import com.signingSimulator.signingSimulator.domain.exceptions.SigningSimulatorServiceException;
import com.signingSimulator.signingSimulator.domain.exceptions.SigningSimulatorServiceExceptionEnum;
import com.signingSimulator.signingSimulator.infrastructure.adapter.output.persistance.entity.CertificateEntity;
import com.signingSimulator.signingSimulator.infrastructure.adapter.output.persistance.repository.mapper.CertificateServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CertificateJpaAdapter implements CertificateDAO {


    private CertificateJpaRepository certificateJpaRepository;

    private CertificateServiceMapper certificateServiceMapper;

    @Autowired
    public CertificateJpaAdapter(CertificateJpaRepository certificateJpaRepository, CertificateServiceMapper certificateServiceMapper) {
        this.certificateJpaRepository = certificateJpaRepository;
        this.certificateServiceMapper = certificateServiceMapper;
    }

    @Override
    public List<Certificate> getCertificatesByUserId(Long userId) {
        return certificateServiceMapper.toListDTO(
                certificateJpaRepository.getCertificatesByUserId(userId)
        );
    }

    @Override
    public Certificate uploadCertificate(Certificate certificate) {
        return certificateServiceMapper.toDTO(
                certificateJpaRepository.save(
                        certificateServiceMapper.toEntity(certificate)
                )
        );
    }

    @Override
    public Certificate getCertificateById(Long id) {
        CertificateEntity certificateEntity = certificateJpaRepository.findById(id).orElseThrow(() ->
                new SigningSimulatorServiceException(SigningSimulatorServiceExceptionEnum.CERTIFICATES_EMPTY));
        return certificateServiceMapper.toDTO(certificateEntity);
    }


}
