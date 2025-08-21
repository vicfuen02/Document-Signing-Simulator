package com.signingSimulator.signingSimulator.infrastructure.adapter.output.event.kafka;

import com.signingSimulator.signingSimulator.domain.event.BaseEvent;

import java.io.Serializable;

public interface KafkaMessagePublisher<K extends Serializable, V extends BaseEvent> {


    void publishEvent(String topic, K key, V message);

}
