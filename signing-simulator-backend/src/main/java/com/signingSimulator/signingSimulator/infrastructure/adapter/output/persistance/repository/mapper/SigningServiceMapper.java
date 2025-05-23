package com.signingSimulator.signingSimulator.infrastructure.adapter.output.persistance.repository.mapper;

import com.signingSimulator.signingSimulator.domain.Document;
import com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.dto.DocumentReqDTO;
import com.signingSimulator.signingSimulator.infrastructure.adapter.output.persistance.entity.DocumentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class SigningServiceMapper {

    public abstract Document toDTO(DocumentEntity document);
    public abstract DocumentEntity toEntity(Document document);

}
