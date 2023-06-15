package com.example.subscriptionapi.sub.rabbitmq;

import com.example.subscriptionapi.sub.dto.SubscriptionRequest;
import com.example.subscriptionapi.sub.model.SubscriptionModel;
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
            rabbitTemplate.convertAndSend(subscriptionTopicExchange, subscriptionRoutingKey, message);
            log.info("Message sent: {}", new ObjectMapper().writeValueAsString(message));
        } catch (Exception e) {
            log.info("Error in produceMessage method", e);
        }
    }

    public void produceMessageSubscription(SubscriptionModel message) {
        try{
            rabbitTemplate.convertAndSend(subscriptionTopicExchange, subscriptionRoutingKey, message);
            log.info("Message sent: {}", new ObjectMapper().writeValueAsString(message));
        } catch (Exception e) {
            log.info("Error in produceMessage method", e);
        }
    }

}
