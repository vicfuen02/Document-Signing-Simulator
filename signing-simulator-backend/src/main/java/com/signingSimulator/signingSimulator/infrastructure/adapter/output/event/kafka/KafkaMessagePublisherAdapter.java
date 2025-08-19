package com.signingSimulator.signingSimulator.infrastructure.adapter.output.event.kafka;

import com.signingSimulator.signingSimulator.application.ports.output.messaging.MessagePublisher;
import com.signingSimulator.signingSimulator.domain.event.BaseEvent;

public class KafkaMessagePublisherAdapter implements MessagePublisher {


    private final KafkaMessagePublisher kafkaMessagePublisher;

    public KafkaMessagePublisherAdapter(KafkaMessagePublisher kafkaMessagePublisher) {
        this.kafkaMessagePublisher = kafkaMessagePublisher;
    }


    @Override
    public void publishEvent(BaseEvent event) {
        kafkaMessagePublisher.publishEvent("","", event);
    }



}
