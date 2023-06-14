package com.example.subscriptionapi.sub.rabbitmq;

import com.example.subscriptionapi.sub.dto.SubscriptionRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SubscriptionProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${app-config.rabbit.exchange.subscription-api}")
    private String subscriptionTopicExchange;

    @Value("${app-config.rabbit.routingKey.subscription-update}")
    private String subscriptionRoutingKey;

    public void produceMessage(SubscriptionRequest message) {
        try{
            log.info("Sending message: {}", new ObjectMapper().writeValueAsString(message));
            rabbitTemplate.convertAndSend(subscriptionTopicExchange, subscriptionRoutingKey, message);
            log.info("Message was sent successfully.");
        } catch (Exception e) {
            log.info("Erro no metodo produceMessage", e);
        }
    }

}
