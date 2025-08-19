package com.signingSimulator.signingSimulator.application.service.signing.postSigning;

import com.signingSimulator.signingSimulator.application.ports.input.signing.PostSigningChainOfResponsability;
import com.signingSimulator.signingSimulator.application.ports.input.signing.PostSigningHandler;
import com.signingSimulator.signingSimulator.domain.certificate.Certificate;
import com.signingSimulator.signingSimulator.domain.document.Document;
import com.signingSimulator.signingSimulator.domain.signing.PostSigningResult;
import com.signingSimulator.signingSimulator.domain.signing.PostSingingContext;
import com.signingSimulator.signingSimulator.domain.exceptions.SigningSimulatorServiceException;
import com.signingSimulator.signingSimulator.domain.exceptions.SigningSimulatorServiceExceptionEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostSigningChain implements PostSigningChainOfResponsability {


    private static final Logger log = LogManager.getLogger(PostSigningChain.class);

    private List<PostSigningHandler> chain = new ArrayList<>();

    @Autowired
    public PostSigningChain(List<PostSigningHandler> chain) {
        this.chain = chain;
    }


    @Override
    public PostSingingContext call(Document document, Certificate certificate) {

        log.info("Starting post signing handlers");

        PostSingingContext ctx = new PostSigningResult(document, certificate);
        for (PostSigningHandler handler: this.chain) {
            ctx = handler.handle(ctx);
            if (!ctx.getHandledSuccessfully()) {
                throw new SigningSimulatorServiceException(SigningSimulatorServiceExceptionEnum.ERROR_POST_SIGNING);
            }
        }
        ctx.setHandledSuccessfully(true);

        return ctx;
    }


}
