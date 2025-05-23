package com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest;

import com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.dto.DocumentReqDTO;
import com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.mapper.SigningRestControllerMapper;
import com.signingSimulator.signingSimulator.infrastructure.adapter.output.persistance.entity.DocumentEntity;
import com.signingSimulator.signingSimulator.application.ports.input.SigningService;
import com.signingSimulator.signingSimulator.domain.exceptions.ServiceException;
import com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.dto.SigningResDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // creando una capa de servicios REST - transformación en JSON
@RequestMapping("/sign")
public class SigningRestController extends BaseRestController {

    Logger LOGGER = LoggerFactory.getLogger(SigningRestController.class);


    private SigningService signingService;

    private SigningRestControllerMapper signingRestControllerMapper;

    @Autowired
    public SigningRestController(SigningService signingService, SigningRestControllerMapper signingRestControllerMapper) {
        this.signingService = signingService;
        this.signingRestControllerMapper = signingRestControllerMapper;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<SigningResDTO> signDocument(@PathVariable String userId, @RequestBody DocumentReqDTO document) {

        SigningResDTO signingResDTO = new SigningResDTO();

        ResponseEntity<SigningResDTO> response = null;

        try {
            signingResDTO = this.signingService.signDocument(userId, signingRestControllerMapper.toDTO(document));
            signingResDTO.setSuccess(true);
            response = ResponseEntity.ok()
                    .body(signingResDTO);
        } catch (ServiceException e) {
            signingResDTO.setMessage(e.getMessage());
            response = ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(signingResDTO);
        }

        return response;
    }


}
