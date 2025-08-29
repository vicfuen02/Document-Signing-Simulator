package com.signingSimulator.signingSimulator.infrastructure.adapter.output.event.kafka;

import com.signingSimulator.signingSimulator.domain.event.BaseEvent;
import jakarta.annotation.PreDestroy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.concurrent.CompletableFuture;


@Component
public class KafkaMessagePublisherImpl<K extends Serializable, V extends BaseEvent> implements KafkaMessagePublisher<K, V> {


    private static final Logger log = LogManager.getLogger(KafkaMessagePublisherImpl.class);


    private final KafkaTemplate<K, V> kafkaTemplate;

    @Autowired
    public KafkaMessagePublisherImpl(KafkaTemplate<K, V> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }



    @Override
    public void publishEvent(String topic, K key, V message) {

        log.info("KafkaMessagePublisherImpl.publishEvent INIT");

        CompletableFuture<SendResult<K, V>> kafkaResultFuture = kafkaTemplate.send(topic, key, message);
        kafkaResultFuture.whenComplete((res, error) -> {
            if (error != null) {
                log.info("Kafka publisher callback ERROR ({})", res);
            } else {
                log.info("Kafka publisher callback OKAY ({})", res);
            }
        });

        log.info("KafkaMessagePublisherImpl.publishEvent END");

    }

    @PreDestroy
    public void close(){
        if(kafkaTemplate != null){
            log.info("Closing kafka producer");
            kafkaTemplate.destroy();
        }
    }






}
