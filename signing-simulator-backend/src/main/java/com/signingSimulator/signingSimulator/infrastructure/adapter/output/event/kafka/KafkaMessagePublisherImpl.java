package com.signingSimulator.signingSimulator.infrastructure.adapter.output.event.kafka;

import com.signingSimulator.signingSimulator.domain.event.BaseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisherImpl implements KafkaMessagePublisher {


    private final KafkaTemplate<String, BaseEvent> kafkaTemplate;

    @Autowired
    public KafkaMessagePublisherImpl(KafkaTemplate<String, BaseEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }



    @Override
    public void publishEvent(String topic, String key, BaseEvent message) {

        CompletableFuture<SendResult<String, BaseEvent>> completableFuture = kafkaTemplate.send(topic, key, message);

    }






}
