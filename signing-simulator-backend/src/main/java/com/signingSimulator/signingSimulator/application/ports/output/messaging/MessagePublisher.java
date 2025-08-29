package com.signingSimulator.signingSimulator.application.ports.output.messaging;

import com.signingSimulator.signingSimulator.domain.event.EventPayload;

public interface MessagePublisher<K extends EventPayload> {


    void publishEvent(K event);

}
