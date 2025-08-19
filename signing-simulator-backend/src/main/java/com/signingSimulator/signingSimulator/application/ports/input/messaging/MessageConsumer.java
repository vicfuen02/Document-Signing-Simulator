package com.signingSimulator.signingSimulator.application.ports.input.messaging;

import com.signingSimulator.signingSimulator.domain.event.ReceivedEvent;

public interface MessageConsumer {

    void consumeEvent(ReceivedEvent event);

}
