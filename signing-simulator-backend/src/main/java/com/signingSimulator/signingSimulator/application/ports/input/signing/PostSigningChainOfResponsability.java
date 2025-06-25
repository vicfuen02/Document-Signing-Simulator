package com.signingSimulator.signingSimulator.application.ports.input.signing;

import com.signingSimulator.signingSimulator.domain.Certificate;
import com.signingSimulator.signingSimulator.domain.Document;
import com.signingSimulator.signingSimulator.domain.PostSingingContext;

public interface PostSigningChainOfResponsability {

    PostSingingContext call(Document document, Certificate certificate);


}
