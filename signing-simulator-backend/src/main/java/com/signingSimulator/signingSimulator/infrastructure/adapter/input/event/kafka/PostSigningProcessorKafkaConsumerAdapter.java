package com.signingSimulator.signingSimulator.infrastructure.adapter.input.event.kafka;

import com.signingSimulator.signingSimulator.application.ports.input.messaging.MessageConsumer;
import com.signingSimulator.signingSimulator.application.ports.input.signing.PostSigningChainOfResponsability;
import com.signingSimulator.signingSimulator.domain.exceptions.SigningSimulatorServiceException;
import com.signingSimulator.signingSimulator.domain.exceptions.SigningSimulatorServiceExceptionEnum;
import com.signingSimulator.signingSimulator.domain.signing.PostSigningEvent;
import com.signingSimulator.signingSimulator.domain.signing.PostSigningPayload;
import com.signingSimulator.signingSimulator.infrastructure.kafka.helper.KafkaHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.retry.annotation.Backoff;
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

    @RetryableTopic(attempts = "4", backoff = @Backoff(delay = 1000L, multiplier = 2))
    @KafkaListener(topics="post-signing-topic", groupId="signing-simulator-group-1")
    public void consumeEvent(PostSigningEvent event
                             ,@Header(KafkaHeaders.RECEIVED_TOPIC) String topic
    ) {
        log.info("PostSigningProcessorKafkaConsumerAdapter.consumeEvent successfully" +
                " topic: ({}), event: ({})", topic, event);

        PostSigningPayload payload = kafkaHelper.getDeserializedPayload(event.getPayload(), PostSigningPayload.class);
        if (payload.getCertificate().getId() % 2 == 0) {
            throw new SigningSimulatorServiceException(SigningSimulatorServiceExceptionEnum.KAFKA_CONSUMER_ERROR);
        }

        postSigning.call(payload.getDocument(), payload.getCertificate());

        log.info("PostSigningProcessorKafkaConsumerAdapter.consumeEvent END");
    }

    @DltHandler
    public void consumeEventDLT(PostSigningEvent event
                                ,@Header(KafkaHeaders.RECEIVED_TOPIC) String topic
    ) {
        log.info("DLT!!! PostSigningProcessorKafkaConsumerAdapter.consumeEventDLT" +
                " topic: ({}), event: ({})", topic, event);
    }


}
