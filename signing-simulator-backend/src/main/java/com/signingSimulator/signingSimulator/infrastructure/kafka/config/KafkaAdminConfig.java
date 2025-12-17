package com.signingSimulator.signingSimulator.infrastructure.kafka.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaAdminConfig {

    private final KafkaDataConfig kafkaDataConfig;

    @Autowired
    public KafkaAdminConfig(KafkaDataConfig kafkaDataConfig) {
        this.kafkaDataConfig = kafkaDataConfig;
    }

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaDataConfig.getBootstrapServers());
        return new KafkaAdmin(configs);
    }
}
