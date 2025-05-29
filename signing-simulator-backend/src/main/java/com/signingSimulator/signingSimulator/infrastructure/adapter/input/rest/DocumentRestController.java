package com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest;

import com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.dto.DocumentReqDTO;
import com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.dto.DocumentResDTO;
import com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.mapper.DocumentRestControllerMapper;
import com.signingSimulator.signingSimulator.application.ports.input.SigningService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/document")
public class DocumentRestController extends BaseRestController {

    Logger LOGGER = LoggerFactory.getLogger(DocumentRestController.class);


    private SigningService signingService;

    private DocumentRestControllerMapper documentRestControllerMapper;

    @Autowired
    public DocumentRestController(SigningService signingService, DocumentRestControllerMapper documentRestControllerMapper) {
        this.signingService = signingService;
        this.documentRestControllerMapper = documentRestControllerMapper;
    }

    @PostMapping("/sign/{certificateId}")
    public DocumentResDTO signDocument(@PathVariable Long certificateId, @RequestBody DocumentReqDTO documentReqDTO) {

        documentReqDTO.setCertificateId(certificateId);

        return documentRestControllerMapper.toResDTO(
                this.signingService.signDocument(
                        documentRestControllerMapper.toDTO(documentReqDTO),
                        documentRestControllerMapper.toCertificate(documentReqDTO)
                )
        );
    }


}
