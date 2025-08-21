package com.signingSimulator.signingSimulator.infrastructure.adapter.input.event.kafka;

import com.signingSimulator.signingSimulator.application.ports.input.messaging.MessageConsumer;
import com.signingSimulator.signingSimulator.application.ports.input.signing.PostSigningChainOfResponsability;
import com.signingSimulator.signingSimulator.domain.signing.PostSigningEvent;
import com.signingSimulator.signingSimulator.domain.signing.PostSigningPayload;
import com.signingSimulator.signingSimulator.infrastructure.kafka.helper.KafkaHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PostSigningProcessorKafkaConsumerAdapter implements MessageConsumer<PostSigningEvent> {


    private static final Logger log = LogManager.getLogger(PostSigningProcessorKafkaConsumerAdapter.class);

    private final KafkaHelper kafkaHelper;
    private final PostSigningChainOfResponsability postSigning;

    @Autowired
    public PostSigningProcessorKafkaConsumerAdapter(PostSigningChainOfResponsability postSigning, KafkaHelper kafkaHelper) {
        this.postSigning = postSigning;
        this.kafkaHelper = kafkaHelper;
    }

    @KafkaListener(topics="post-signing-topic", groupId="signing-simulator-group-1")
    public void consumeEvent(PostSigningEvent event) {

        log.info("PostSigningProcessorKafkaConsumerAdapter.consumeEvent successfully :) ({})", event);
        try {
            log.info("Processing...");
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            log.error("Error in thread.sleep");
        }

        PostSigningPayload payload = kafkaHelper.getDeserializedPayload(event.getPayload(), PostSigningPayload.class);

        postSigning.call(payload.getDocument(), payload.getCertificate());

        log.info("PostSigningProcessorKafkaConsumerAdapter.consumeEvent END");
    }


}
