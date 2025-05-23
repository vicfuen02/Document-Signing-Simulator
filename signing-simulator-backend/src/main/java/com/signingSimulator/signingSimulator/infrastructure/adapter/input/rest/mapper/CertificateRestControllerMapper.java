package com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.mapper;


import com.signingSimulator.signingSimulator.domain.Certificate;
import com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.dto.CertificateReqDTO;
import com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.dto.CertificateResDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CertificateRestControllerMapper {


    public abstract CertificateResDTO toResDTO(Certificate certificate);
    public abstract Certificate toDTO(CertificateReqDTO certificateResDTO);


}
