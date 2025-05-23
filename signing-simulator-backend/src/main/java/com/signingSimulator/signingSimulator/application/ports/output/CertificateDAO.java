package com.signingSimulator.signingSimulator.application.ports.output;

import com.signingSimulator.signingSimulator.domain.Certificate;
import java.util.List;

public interface CertificateDAO {


    List<Certificate> getCertificateByUserId(String userId);

    Boolean uploadCertificate(String userId, Certificate certificate);

}
