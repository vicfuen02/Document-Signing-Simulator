package com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.mapper;

import com.signingSimulator.signingSimulator.domain.User;
import com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.dto.UserReqDTO;
import com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.dto.UserResDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class UserRestControllerMapper {


    public abstract UserResDTO toResDTO(User certificate);
    public abstract List<UserResDTO> toListResDTO(List<User> certificate);
    public abstract User toDTO(UserReqDTO certificateResDTO);

}
