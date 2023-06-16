package com.example.subscriptionapi.sub.rabbitmq;

import com.example.subscriptionapi.sub.model.SubscriptionModel;
import com.example.subscriptionapi.sub.model.SubscriptionModel2;
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

    @Value("${app-config.rabbit.routingKey.consumer-update}")
    private String consumerRoutingKey;

    private final ObjectMapper objectMapper;

    public SubscriptionProducer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public void produceMessage(SubscriptionModel message) {
        try{
            rabbitTemplate.convertAndSend(subscriptionTopicExchange, subscriptionRoutingKey, message);
            rabbitTemplate.convertAndSend(subscriptionTopicExchange, consumerRoutingKey, message);
            log.info("Message sent: {}", this.objectMapper.writeValueAsString(message));
        } catch (Exception e) {
            log.info("Error in produceMessage method", e);
        }
    }

    public void produceMessageSubscription2(SubscriptionModel2 message) {
        try{
            rabbitTemplate.convertAndSend(subscriptionTopicExchange, subscriptionRoutingKey, message);
            rabbitTemplate.convertAndSend(subscriptionTopicExchange, consumerRoutingKey, message);
            log.info("Message sent: {}", this.objectMapper.writeValueAsString(message));
        } catch (Exception e) {
            log.info("Error in produceMessage method", e);
        }
    }

}
