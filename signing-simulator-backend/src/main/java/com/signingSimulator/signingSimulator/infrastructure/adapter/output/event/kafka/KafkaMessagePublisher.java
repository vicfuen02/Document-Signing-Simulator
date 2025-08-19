package com.signingSimulator.signingSimulator.infrastructure.adapter.output.event.kafka;

import com.signingSimulator.signingSimulator.domain.event.BaseEvent;

public interface KafkaMessagePublisher {


    void publishEvent(String topic, String key, BaseEvent message);

}
