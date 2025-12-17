package com.signingSimulator.signingSimulator.application.service.signing.signingTypes;

import com.signingSimulator.signingSimulator.domain.certificate.Certificate;
import com.signingSimulator.signingSimulator.domain.document.Document;
import com.signingSimulator.signingSimulator.domain.exceptions.SigningSimulatorServiceException;
import com.signingSimulator.signingSimulator.domain.exceptions.SigningSimulatorServiceExceptionEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SigningDocumentFactory {


    private List<SigningDocumentStrategy> signingDocumentStrategyList;

    @Autowired
    public SigningDocumentFactory(List<SigningDocumentStrategy> signingDocumentStrategyList) {
        this.signingDocumentStrategyList = signingDocumentStrategyList;
    }

    public SigningDocumentStrategy getStrategy(Document document, Certificate certificate) {

        return signingDocumentStrategyList
                .stream()
                .filter(strategy -> strategy.getType().equals(document.getType().name()))
                .findFirst()
                .orElseThrow(() -> new SigningSimulatorServiceException(SigningSimulatorServiceExceptionEnum.INVALID_DOCUMENT_TYPE));

    }

}
