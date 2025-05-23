package com.signingSimulator.signingSimulator.infrastructure.adapter.output.persistance.repository.mapper;

import com.signingSimulator.signingSimulator.domain.User;
import com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.dto.UserReqDTO;
import com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.dto.UserResDTO;
import com.signingSimulator.signingSimulator.infrastructure.adapter.output.persistance.entity.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class UserServiceMapper {


    public abstract UserEntity toEntity(User certificate);
    public abstract List<User> toListDTO(List<UserEntity> certificate);
    public abstract User toDTO(UserEntity certificateResDTO);

}
