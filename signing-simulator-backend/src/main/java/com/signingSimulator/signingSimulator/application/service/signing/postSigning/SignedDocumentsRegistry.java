package com.signingSimulator.signingSimulator.application.service.signing.postSigning;

import com.signingSimulator.signingSimulator.application.ports.input.signing.PostSigningHandler;
import com.signingSimulator.signingSimulator.domain.Document;
import com.signingSimulator.signingSimulator.domain.PostSingingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class SignedDocumentsRegistry implements PostSigningHandler {

    private static final Logger log = LogManager.getLogger(SignedDocumentsRegistry.class);


    @Override
    public PostSingingContext handle(PostSingingContext ctx) {
        log.info("SignedDocumentsRegistry -- START");

        ctx.setHandledSuccessfully(true);
        return ctx;
    }

}
