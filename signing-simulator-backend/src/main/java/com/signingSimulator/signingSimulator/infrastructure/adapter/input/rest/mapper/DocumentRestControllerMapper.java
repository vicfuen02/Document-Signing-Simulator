package com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.mapper;

import com.signingSimulator.signingSimulator.domain.certificate.Certificate;
import com.signingSimulator.signingSimulator.domain.document.Document;
import com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.dto.DocumentReqDTO;
import com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.dto.DocumentResDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class DocumentRestControllerMapper {

    public abstract Document toDTO(DocumentReqDTO document);
    public Certificate toCertificate(DocumentReqDTO documentReqDTO) {

        Certificate certificate = new Certificate();
        certificate.setId(documentReqDTO.getCertificateId());
        certificate.setPassword(documentReqDTO.getCertificatePassword());
        return certificate;
    };
    public abstract DocumentResDTO toResDTO(Document document);

}
