package com.signingSimulator.signingSimulator.infrastructure.adapter.input.event.kafka;

import com.signingSimulator.signingSimulator.application.ports.input.messaging.MessageConsumer;
import com.signingSimulator.signingSimulator.domain.event.ReceivedEvent;

public class KafkaMessageConsumerAdapter implements MessageConsumer {
    @Override
    public void consumeEvent(ReceivedEvent event) {

    }
}
