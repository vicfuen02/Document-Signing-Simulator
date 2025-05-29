package com.signingSimulator.signingSimulator.application.ports.input;

import com.signingSimulator.signingSimulator.domain.Certificate;

import java.util.List;

public interface CertificateService {

    List<Certificate> getCertificatesByUserId(Long userId);

    List<Certificate> uploadCertificate(Certificate certificate);

    Certificate getCertificateById(Long id);

    Boolean checkCertificateCredentials(Certificate certificate);

}
