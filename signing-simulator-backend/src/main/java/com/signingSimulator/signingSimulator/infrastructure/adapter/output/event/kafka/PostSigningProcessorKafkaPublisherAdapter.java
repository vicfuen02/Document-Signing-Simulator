package com.signingSimulator.signingSimulator.infrastructure.adapter.output.event.kafka;

import com.signingSimulator.signingSimulator.application.ports.output.messaging.MessagePublisher;
import com.signingSimulator.signingSimulator.domain.signing.PostSigningEvent;
import com.signingSimulator.signingSimulator.domain.signing.PostSigningPayload;
import com.signingSimulator.signingSimulator.infrastructure.kafka.helper.KafkaHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostSigningProcessorKafkaPublisherAdapter implements MessagePublisher<PostSigningPayload> {

    private static final Logger log = LogManager.getLogger(PostSigningProcessorKafkaPublisherAdapter.class);


    private final KafkaMessagePublisher<String, PostSigningEvent> kafkaMessagePublisher;
    private final KafkaHelper kafkaHelper;

    @Autowired
    public PostSigningProcessorKafkaPublisherAdapter(KafkaMessagePublisher<String, PostSigningEvent> kafkaMessagePublisher, KafkaHelper kafkaHelper) {
        this.kafkaMessagePublisher = kafkaMessagePublisher;
        this.kafkaHelper = kafkaHelper;
    }


    @Override
    public void publishEvent(PostSigningPayload payload) {

        log.info("PostSigningProcessorKafkaPublisherAdapter.publishEvent INIT");

        PostSigningEvent event = new PostSigningEvent();
        event.setPayload(kafkaHelper.createPayload(payload));

        kafkaMessagePublisher.publishEvent("post-signing-topic","document.signed.kafka.key", event);

        log.info("PostSigningProcessorKafkaPublisherAdapter.publishEvent END");
    }




}
