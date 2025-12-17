package com.signingSimulator.signingSimulator.application.service.signing.signingTypes;

import com.signingSimulator.signingSimulator.domain.certificate.Certificate;
import com.signingSimulator.signingSimulator.domain.document.Document;
import org.springframework.stereotype.Component;

@Component
public abstract class SigningTypeAbstract {

    protected Document addSignMark(Document document, String type, Certificate certificate) {

        String signature = "Singed " + type + " document by: " + certificate.getName() + ". ";

        Document doc = new Document();
        doc.setSigned(true);
        doc.setDocument(signature + document.getDocument());
        return doc;
    }
}
