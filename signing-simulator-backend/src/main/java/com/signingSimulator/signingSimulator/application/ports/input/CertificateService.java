package com.signingSimulator.signingSimulator.application.ports.input;

import com.signingSimulator.signingSimulator.domain.Certificate;
import com.signingSimulator.signingSimulator.domain.exceptions.ServiceException;
import com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.dto.CertificateResDTO;

public interface CertificateService {

    CertificateResDTO getCertificateByUserId(String userId);

    CertificateResDTO uploadCertificate(String userId, Certificate certificate) throws ServiceException;

}
