package com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest;

import com.signingSimulator.signingSimulator.application.ports.input.LoginService;
import com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.dto.LoginResDTO;
import com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.dto.UserReqDTO;
import com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.mapper.UserRestControllerMapper;
import com.signingSimulator.signingSimulator.domain.exceptions.SigningSimulatorServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // creando una capa de servicios REST - transformación en JSON
@RequestMapping("/login")
public class LoginRestController extends BaseRestController {


    private LoginService loginService;

    private UserRestControllerMapper userRestControllerMapper;

    Logger LOGGER = LoggerFactory.getLogger(LoginRestController.class);

    @Autowired
    public LoginRestController(LoginService loginService, UserRestControllerMapper userRestControllerMapper) {
        this.loginService = loginService;
        this.userRestControllerMapper = userRestControllerMapper;
    }

    @PostMapping
    public ResponseEntity<LoginResDTO> logIn(@RequestBody UserReqDTO user) {
        LOGGER.info("log user controller: " + user.toString());


        HttpHeaders responseHeaders = new HttpHeaders();
        LoginResDTO loginResDTO = new LoginResDTO();
        ResponseEntity<LoginResDTO> response = null;
        try {
            LoginResDTO serviceResponse = this.loginService.logIn(userRestControllerMapper.toDTO(user));
            responseHeaders.set(super.TOKEN_HEADER, serviceResponse.getMessage());
            responseHeaders.set(super.VISIBILITY_HEADER, super.TOKEN_HEADER);
            serviceResponse.setSuccess(true);
            response = ResponseEntity.ok()
                    .headers(responseHeaders)
                    .body(serviceResponse);

        } catch (SigningSimulatorServiceException e) {
            loginResDTO.setMessage(e.getMessage());
            response = ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(loginResDTO);
        }
        return response;
    }




}
