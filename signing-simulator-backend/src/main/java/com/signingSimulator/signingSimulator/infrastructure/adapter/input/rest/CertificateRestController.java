package com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest;

import com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.dto.CertificateReqDTO;
import com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.mapper.CertificateRestControllerMapper;
import com.signingSimulator.signingSimulator.infrastructure.adapter.output.persistance.entity.CertificateEntity;
import com.signingSimulator.signingSimulator.application.ports.input.CertificateService;
import com.signingSimulator.signingSimulator.domain.exceptions.ServiceException;
import com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.dto.CertificateResDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/documents")
public class CertificateRestController extends BaseRestController {

    Logger LOGGER = LoggerFactory.getLogger(CertificateRestController.class);


    private CertificateService certificateService;

    private CertificateRestControllerMapper certificateRestControllerMapper;

    @Autowired
    public CertificateRestController(CertificateService certificateService, CertificateRestControllerMapper certificateRestControllerMapper) {
        this.certificateService = certificateService;
        this.certificateRestControllerMapper = certificateRestControllerMapper;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<CertificateResDTO> getUserCertificate(@PathVariable String userId) {

        ResponseEntity<CertificateResDTO> response = null;
        CertificateResDTO serviceResponse = new CertificateResDTO();
        List<CertificateEntity> certificates = new ArrayList<>();

        serviceResponse = this.certificateService.getCertificateByUserId(userId);
        serviceResponse.setSuccess(true);
        response = ResponseEntity.ok()
                .body(serviceResponse);

        return response;
    }

    @PostMapping("/upload/{userId}")
    public ResponseEntity<CertificateResDTO> uploadCertificate(@PathVariable String userId, @RequestBody CertificateReqDTO certificate) {

        List<CertificateEntity> certificateEntities = new ArrayList<>();

        ResponseEntity<CertificateResDTO> response = null;
        CertificateResDTO certificateResDTO = new CertificateResDTO();

        try {
            certificateResDTO = this.certificateService.uploadCertificate(userId, certificateRestControllerMapper.toDTO(certificate));
            certificateResDTO.setSuccess(true);
            response = ResponseEntity.ok()
                    .body(certificateResDTO);
        } catch (ServiceException e) {
            certificateResDTO.setMessage(e.getMessage());
            response = ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(certificateResDTO);
        }

        return response;
    }



}
