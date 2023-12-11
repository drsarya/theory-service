package com.example.statisticservice.queue.consumer;

import com.example.statisticservice.queue.model.StatisticModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Handler for incoming events from kafka.
 */
@Slf4j
@Component
public class MessageConsumerService {

    private final ApplicationEventPublisher eventPublisher;

    public MessageConsumerService(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    /**
     * Event listener
     *
     * @param message the message represented by the string
     */
    @KafkaListener(topics = {"${settings.kafka.topic}"})
    public void receive(ConsumerRecord<String, StatisticModel> message) {
        try {
            log.info("Message received [{}]", message);
            eventPublisher.publishEvent(message.value());
        } catch (Exception e) {
            log.error("Error proceed while publish event", e);
        }
    }
}
