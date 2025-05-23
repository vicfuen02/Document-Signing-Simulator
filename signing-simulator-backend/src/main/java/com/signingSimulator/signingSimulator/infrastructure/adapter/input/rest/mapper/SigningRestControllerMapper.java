package com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.mapper;

import com.signingSimulator.signingSimulator.domain.Document;
import com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.dto.DocumentReqDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class SigningRestControllerMapper {

    public abstract Document toDTO(DocumentReqDTO document);

}
