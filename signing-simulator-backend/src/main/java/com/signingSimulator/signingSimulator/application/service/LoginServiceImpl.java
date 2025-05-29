package com.signingSimulator.signingSimulator.application.service;

import com.signingSimulator.signingSimulator.application.ports.input.LoginService;
import com.signingSimulator.signingSimulator.application.ports.input.UserService;
import com.signingSimulator.signingSimulator.application.ports.input.CacheService;
import com.signingSimulator.signingSimulator.domain.User;
import com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.dto.LoginResDTO;
import com.signingSimulator.signingSimulator.infrastructure.adapter.output.persistance.entity.UserEntity;
import com.signingSimulator.signingSimulator.common.interceptors.CacheEnum;
import com.signingSimulator.signingSimulator.domain.exceptions.SigningSimulatorServiceException;
import com.signingSimulator.signingSimulator.domain.exceptions.SigningSimulatorServiceExceptionEnum;
import com.signingSimulator.signingSimulator.common.interceptors.PasswordsUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoginServiceImpl implements LoginService {

    Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private CacheService cacheService;

    @Autowired
    private PasswordsUtils passwordsUtils;

    @Autowired
    private UserService userService;

    public LoginResDTO logIn(User userEntity) throws SigningSimulatorServiceException {
        LOGGER.info("log user service: " + userEntity.toString());
        User user = this.userService.getByUserName(userEntity.getName());
        if (user == null) {
            throw new SigningSimulatorServiceException(SigningSimulatorServiceExceptionEnum.USER_NOT_FOUND);
        }

        if (!user.getPassword().equals(this.passwordsUtils.encryptPass(userEntity.getPassword()))) {
            throw new SigningSimulatorServiceException(SigningSimulatorServiceExceptionEnum.WRONG_PASSWORD);
        }

        String token = this.generateLoginToken();
        this.cacheService.setValueCache(CacheEnum.LOGGED_USERS.getCode(), token, this.userService.getByUserName(userEntity.getName()));
        LoginResDTO response = new LoginResDTO();
        response.setMessage(token);
        user.setPassword(null);
        response.setUser(user);

        return response;
    }

    @Override
    public LoginResDTO logOut(User userEntity) throws SigningSimulatorServiceException {
        return null;
    }


    private String generateLoginToken() {
        String generatedString = UUID.randomUUID().toString();
        LOGGER.info("generatedString: " + generatedString);
        return generatedString;
    }




}
