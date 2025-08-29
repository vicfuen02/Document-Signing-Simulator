package com.signingSimulator.signingSimulator.infrastructure.kafka.config.producer;


import com.signingSimulator.signingSimulator.domain.event.BaseEvent;
import com.signingSimulator.signingSimulator.infrastructure.kafka.config.KafkaDataConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig<K extends Serializable, V extends BaseEvent> {


    private KafkaDataConfig kafkaDataConfig;
    private KafkaProducerDataConfig kafkaProducerDataConfig;

    @Autowired
    public KafkaProducerConfig(KafkaDataConfig kafkaDataConfig, KafkaProducerDataConfig kafkaProducerDataConfig) {
        this.kafkaDataConfig = kafkaDataConfig;
        this.kafkaProducerDataConfig = kafkaProducerDataConfig;
    }

    @Bean
    public Map<String, Object> producerConfig() {

        Map<String, Object> properties = new HashMap<>();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,         kafkaDataConfig.getBootstrapServers());
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,      kafkaProducerDataConfig.getKeySerializer());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,    kafkaProducerDataConfig.getValueSerializer());

        return properties;
    }

    @Bean
    public ProducerFactory<K, V> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }

    @Bean
    public KafkaTemplate<K, V> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }





}
