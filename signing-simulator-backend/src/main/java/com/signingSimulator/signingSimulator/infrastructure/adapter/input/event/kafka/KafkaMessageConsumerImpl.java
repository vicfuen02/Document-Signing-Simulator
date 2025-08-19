package com.signingSimulator.signingSimulator.infrastructure.adapter.input.event.kafka;


import com.signingSimulator.signingSimulator.domain.event.ReceivedEvent;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageConsumerImpl implements KafkaMessageConsumer {



    public void consumeEvent(ReceivedEvent event) {

    }


}
