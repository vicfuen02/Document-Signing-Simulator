package com.signingSimulator.signingSimulator.domain.event;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class BaseEvent implements Serializable {

    private static final Logger log = LogManager.getLogger(BaseEvent.class);


    private UUID id;
    private Date createdAt;
    private Date processedAt;
    private String payload;

    public BaseEvent() {
        this.id = UUID.randomUUID();
        this.createdAt = new Date();
    }



    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getProcessedAt() {
        return processedAt;
    }

    public void setProcessedAt(Date processedAt) {
        this.processedAt = processedAt;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
}
