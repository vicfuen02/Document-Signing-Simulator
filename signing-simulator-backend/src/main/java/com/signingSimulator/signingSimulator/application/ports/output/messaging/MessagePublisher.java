package com.signingSimulator.signingSimulator.application.ports.output.messaging;

import com.signingSimulator.signingSimulator.domain.event.BaseEvent;

public interface MessagePublisher {


    void publishEvent(BaseEvent event);

}
