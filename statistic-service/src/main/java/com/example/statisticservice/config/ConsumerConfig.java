package com.example.statisticservice.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.converter.BatchMessagingMessageConverter;

@Configuration
public class ConsumerConfig {

    @Bean("kafkaProcessorListenerContainerFactoryBatch")
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> listenerContainerFactoryBatch(
            ConsumerFactory<String, String> consumerFactory) {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        factory.setBatchListener(true);

        factory.setBatchMessageConverter(new BatchMessagingMessageConverter());
        return factory;
    }
}
