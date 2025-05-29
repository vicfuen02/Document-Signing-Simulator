package com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.mapper;


import com.signingSimulator.signingSimulator.domain.Certificate;
import com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.dto.CertificateReqDTO;
import com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.dto.CertificateResDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class CertificateRestControllerMapper {


    public abstract CertificateResDTO toResDTO(Certificate certificate);
    public abstract List<CertificateResDTO> toListResDTO(List<Certificate> certificate);

    @Mapping(target="user.id", source="userId")
    public abstract Certificate toDTO(CertificateReqDTO certificateResDTO);


}
