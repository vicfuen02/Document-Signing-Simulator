package com.signingSimulator.signingSimulator.application.ports.input.signing;

import com.signingSimulator.signingSimulator.domain.certificate.Certificate;
import com.signingSimulator.signingSimulator.domain.document.Document;
import com.signingSimulator.signingSimulator.domain.signing.PostSingingContext;

public interface PostSigningChainOfResponsability {

    PostSingingContext call(Document document, Certificate certificate);


}
