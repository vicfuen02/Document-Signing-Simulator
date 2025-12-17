package com.signingSimulator.signingSimulator.infrastructure.adapter.output.persistance.repository.mapper;


import com.signingSimulator.signingSimulator.domain.certificate.Certificate;
import com.signingSimulator.signingSimulator.infrastructure.adapter.output.persistance.entity.CertificateEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class CertificateServiceMapper {


    public abstract Certificate toDTO(CertificateEntity certificate);
    public abstract CertificateEntity toEntity(Certificate certificateResDTO);
    public abstract List<Certificate> toListDTO(List<CertificateEntity> certificateResDTO);


}
