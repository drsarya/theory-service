package com.example.statisticservice.queue.consumer;

import com.example.statisticservice.queue.model.StatisticModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Iterator;

/**
 * Handler for incoming events from kafka.
 */
@Slf4j
@Component
public class MessageConsumerService {

    private final ApplicationEventPublisher eventPublisher;
    private final ObjectMapper objectMapper;

    public MessageConsumerService(ApplicationEventPublisher eventPublisher, ObjectMapper objectMapper) {
        this.eventPublisher = eventPublisher;
        this.objectMapper = objectMapper;
    }

    //    /**
//     * Event listener
//     *
//     * @param message the message represented by the string
//     */
//    @KafkaListener(topics = {"${settings.kafka.topic}"})
//    public void receive(ConsumerRecord<String, String> message) {
//        try {
//            log.info("Message received [{}]", message);
//            StatisticModel statisticModel = objectMapper.readValue(message.value(), StatisticModel.class);
//            eventPublisher.publishEvent(statisticModel);
//        } catch (Exception e) {
//            log.error("Error proceed while publish event", e);
//        }
//    }

    @KafkaListener(topics = {"${settings.kafka.topic}"}, containerFactory = "kafkaProcessorListenerContainerFactoryBatch")
    public void receive(ConsumerRecords<String, String> messages) {
        log.info("Start batch collection process");
        Iterator<ConsumerRecord<String, String>> iterator = messages.iterator();
        while (iterator.hasNext()) {
            try {
                ConsumerRecord<String, String> next = iterator.next();
                log.info("Message received [{}]", next);
                StatisticModel statisticModel = objectMapper.readValue(next.value(), StatisticModel.class);
                eventPublisher.publishEvent(statisticModel);
            } catch (Exception e) {
                log.error("Error proceed while publish event", e);
            }
        }
    }
}
