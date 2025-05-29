package com.signingSimulator.signingSimulator.application.ports.output;

import com.signingSimulator.signingSimulator.domain.Certificate;
import java.util.List;

public interface CertificateDAO {


    List<Certificate> getCertificatesByUserId(Long userId);

    Certificate uploadCertificate(Certificate certificate);
    Certificate getCertificateById(Long id);

}
