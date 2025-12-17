package com.signingSimulator.signingSimulator.application.ports.input.messaging;

import com.signingSimulator.signingSimulator.domain.event.BaseEvent;

public interface MessageConsumer<K extends BaseEvent> {

    void consumeEvent(K event, String topic);
    void consumeEventDLT(K event, String topic);

}
