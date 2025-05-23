package com.signingSimulator.signingSimulator.application.ports.input;

import com.signingSimulator.signingSimulator.domain.Document;
import com.signingSimulator.signingSimulator.domain.exceptions.ServiceException;
import com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.dto.SigningResDTO;

public interface SigningService {

    SigningResDTO signDocument(String userId, Document document) throws ServiceException;
}
