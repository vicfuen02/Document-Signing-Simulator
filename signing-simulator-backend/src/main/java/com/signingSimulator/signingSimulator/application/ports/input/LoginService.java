package com.signingSimulator.signingSimulator.application.ports.input;

import com.signingSimulator.signingSimulator.domain.User;
import com.signingSimulator.signingSimulator.domain.exceptions.SigningSimulatorServiceException;
import com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.dto.LoginResDTO;

public interface LoginService {

    LoginResDTO logIn(User userEntity) throws SigningSimulatorServiceException;

    LoginResDTO logOut(User userEntity) throws SigningSimulatorServiceException;

}
