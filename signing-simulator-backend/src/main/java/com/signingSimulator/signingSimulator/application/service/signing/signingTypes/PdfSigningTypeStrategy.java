package com.signingSimulator.signingSimulator.application.service.signing.signingTypes;

import com.signingSimulator.signingSimulator.domain.certificate.Certificate;
import com.signingSimulator.signingSimulator.domain.document.Document;
import com.signingSimulator.signingSimulator.domain.document.DocumentType;
import org.springframework.stereotype.Component;

@Component
public class PdfSigningTypeStrategy extends SigningTypeAbstract implements SigningDocumentStrategy {
    @Override
    public Document sign(Document document, Certificate certificate) {
        return this.addSignMark(document, this.getType(), certificate);
    }

    @Override
    public String getType() {
        return DocumentType.PDF.name();
    }
}
