package com.signingSimulator.signingSimulator.application.service.signing.signingTypes;

import com.signingSimulator.signingSimulator.domain.Certificate;
import com.signingSimulator.signingSimulator.domain.Document;
import com.signingSimulator.signingSimulator.domain.DocumentType;
import org.springframework.stereotype.Component;

@Component
public class DocxSigningTypeStrategy extends SigningTypeAbstract implements SigningDocumentStrategy {

    @Override
    public Document sign(Document document, Certificate certificate) {
        return this.addSignMark(document, this.getType(), certificate);
    }

    @Override
    public String getType() {
        return DocumentType.DOCX.name();
    }
}
