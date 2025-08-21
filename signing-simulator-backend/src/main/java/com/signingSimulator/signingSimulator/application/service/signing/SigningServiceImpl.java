package com.signingSimulator.signingSimulator.application.service.signing;

import com.signingSimulator.signingSimulator.application.ports.input.signing.PostSigningChainOfResponsability;
import com.signingSimulator.signingSimulator.application.ports.input.signing.SigningService;
import com.signingSimulator.signingSimulator.application.ports.input.signing.SigningValidator;
import com.signingSimulator.signingSimulator.application.ports.output.messaging.MessagePublisher;
import com.signingSimulator.signingSimulator.application.service.signing.signingTypes.SigningDocumentFactory;
import com.signingSimulator.signingSimulator.application.service.signing.signingTypes.SigningDocumentStrategy;
import com.signingSimulator.signingSimulator.domain.certificate.Certificate;
import com.signingSimulator.signingSimulator.domain.document.Document;
import com.signingSimulator.signingSimulator.domain.signing.PostSigningPayload;
import com.signingSimulator.signingSimulator.domain.signing.SigningValidResult;
import com.signingSimulator.signingSimulator.domain.exceptions.SigningSimulatorServiceException;
import com.signingSimulator.signingSimulator.domain.exceptions.SigningSimulatorServiceExceptionEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SigningServiceImpl implements SigningService {

    private static final Logger log = LogManager.getLogger(SigningServiceImpl.class);


    private final SigningValidator signingValidator;
    private final SigningDocumentFactory signingDocumentFactory;
    private final MessagePublisher<PostSigningPayload> publisher;

    @Autowired
    public SigningServiceImpl(SigningValidator signingValidator, SigningDocumentFactory signingDocumentFactory, MessagePublisher<PostSigningPayload> publisher, PostSigningChainOfResponsability postSigning) {
        this.signingValidator = signingValidator;
        this.signingDocumentFactory = signingDocumentFactory;
        this.publisher = publisher;
    }

    @Override
    public Document sign(Document document, Certificate certificate) {


        SigningValidResult validCertificate = signingValidator.apply(certificate);
        if (!validCertificate.getValid()) {
            throw new SigningSimulatorServiceException(SigningSimulatorServiceExceptionEnum.CERTIFICATE_INVALID);
        }

        SigningDocumentStrategy signingStrategy = signingDocumentFactory.getStrategy(document, certificate);
        Document signedDocument = signingStrategy.sign(document, certificate);

        PostSigningPayload payload = new PostSigningPayload();
        payload.setDocument(document);
        payload.setCertificate(certificate);
//        postSigning.call(document, certificate);
        publisher.publishEvent(payload);


        return signedDocument;
    }




}
