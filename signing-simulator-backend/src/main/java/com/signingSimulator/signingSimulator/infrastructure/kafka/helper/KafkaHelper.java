package com.signingSimulator.signingSimulator.infrastructure.kafka.helper;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.signingSimulator.signingSimulator.domain.exceptions.SigningSimulatorServiceException;
import com.signingSimulator.signingSimulator.domain.exceptions.SigningSimulatorServiceExceptionEnum;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class KafkaHelper {


    private static final Logger log = LogManager.getLogger(KafkaHelper.class);

    public String createPayload(Object payload) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(payload);
        } catch (JsonProcessingException e) {
            log.error("Error creating event payload");
            throw new SigningSimulatorServiceException(SigningSimulatorServiceExceptionEnum.CONVERTING_PAYLOAD_ERROR);
        }
    }

    public <T> T getDeserializedPayload(String payload, Class<T> type) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(payload, type);
        } catch (JsonProcessingException e) {
            log.error("Error creating event payload");
            throw new SigningSimulatorServiceException(SigningSimulatorServiceExceptionEnum.CONVERTING_PAYLOAD_ERROR);
        }
    }


}
