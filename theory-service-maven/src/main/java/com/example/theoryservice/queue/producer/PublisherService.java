package com.example.theoryservice.queue.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Locale;

/**
 * Представляет сервис для взаимодействия с kafka.
 */
@Slf4j
@Service
public class PublisherService {

    private final KafkaTemplate<String, Object> template;

    public PublisherService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.template = kafkaTemplate;
    }

    public void sendMessage(String topic, Object data, String key) {
        template.send(topic, key.toLowerCase(Locale.ROOT), data)
                .handle((result, throwable) -> {
                    if (throwable == null) {
                        log.info("Message successfully sent: {}", result.getProducerRecord().value());
                        log.info("Offset changed to {}", result.getRecordMetadata().offset());
                    } else {
                        log.error("Failed to send message: {}", data, throwable);
                    }
                    return null;
                });
    }
}