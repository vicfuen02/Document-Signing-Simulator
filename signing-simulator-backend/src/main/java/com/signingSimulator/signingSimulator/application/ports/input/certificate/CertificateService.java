package com.signingSimulator.signingSimulator.application.ports.input.certificate;

import com.signingSimulator.signingSimulator.domain.certificate.Certificate;

import java.util.List;

public interface CertificateService {

    List<Certificate> getCertificatesByUserId(Long userId);

    List<Certificate> uploadCertificate(Certificate certificate);

    Certificate getCertificateById(Long id);


}
