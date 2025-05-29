package com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest;

import com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.dto.CertificateReqDTO;
import com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.mapper.CertificateRestControllerMapper;
import com.signingSimulator.signingSimulator.application.ports.input.CertificateService;
import com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.dto.CertificateResDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/certificate")
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
    public List<CertificateResDTO> getCertificatesByUserId(@PathVariable Long userId) {
        return certificateRestControllerMapper.toListResDTO(
                this.certificateService.getCertificatesByUserId(userId)
        );
    }

    @PostMapping("/{userId}")
    public List<CertificateResDTO> uploadCertificate(@PathVariable Long userId, @RequestBody CertificateReqDTO certificate) {
        certificate.setUserId(userId);
        return certificateRestControllerMapper.toListResDTO(
                this.certificateService.uploadCertificate(certificateRestControllerMapper.toDTO(certificate))
        );
    }



}
