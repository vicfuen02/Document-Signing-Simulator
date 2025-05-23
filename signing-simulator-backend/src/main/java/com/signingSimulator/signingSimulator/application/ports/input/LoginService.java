package com.signingSimulator.signingSimulator.application.ports.input;

import com.signingSimulator.signingSimulator.domain.User;
import com.signingSimulator.signingSimulator.domain.exceptions.ServiceException;
import com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.dto.LoginResDTO;

public interface LoginService {

    LoginResDTO logIn(User userEntity) throws ServiceException;

    LoginResDTO logOut(User userEntity) throws ServiceException;

}
