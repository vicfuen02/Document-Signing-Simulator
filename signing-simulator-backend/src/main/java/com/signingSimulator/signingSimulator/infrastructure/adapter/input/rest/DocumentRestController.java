package com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest;

import com.signingSimulator.signingSimulator.application.ports.input.DocumentService;
import com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.dto.DocumentReqDTO;
import com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.dto.DocumentResDTO;
import com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.mapper.DocumentRestControllerMapper;
import com.signingSimulator.signingSimulator.application.ports.input.signing.SigningService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/document")
public class DocumentRestController extends BaseRestController {

    Logger LOGGER = LoggerFactory.getLogger(DocumentRestController.class);


    private DocumentService documentService;

    private DocumentRestControllerMapper documentRestControllerMapper;

    @Autowired
    public DocumentRestController(DocumentService documentService, DocumentRestControllerMapper documentRestControllerMapper) {
        this.documentService = documentService;
        this.documentRestControllerMapper = documentRestControllerMapper;
    }

    @PostMapping("/sign")
    public DocumentResDTO signDocument(@RequestBody DocumentReqDTO documentReqDTO) {
        return documentRestControllerMapper.toResDTO(
                this.documentService.signDocument(
                        documentRestControllerMapper.toDTO(documentReqDTO),
                        documentRestControllerMapper.toCertificate(documentReqDTO)
                )
        );
    }


}
