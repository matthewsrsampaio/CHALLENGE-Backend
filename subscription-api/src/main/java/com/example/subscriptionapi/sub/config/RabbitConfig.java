package com.example.subscriptionapi.sub.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
//
//    @Value("${app-config.rabbit.exchange.subscription-api}")
//    private String subscriptionTopicExchange;
//
//    @Value("${app-config.rabbit.routingKey.subscription-update}")
//    private String subscriptionRoutingKey;
//
//    @Value("${app-config.rabbit.queue.subscription-update}")
//    private String subscriptionQueue;
//
//    @Bean
//    public TopicExchange subscriptionTopicExchange() {
//        return new TopicExchange(subscriptionTopicExchange);
//    }
//
//    @Bean
//    public Queue subscriptionQueue() {
//        return new Queue(subscriptionQueue, true);
//    }
//
//    @Bean
//    public Binding subscriptionTopicQueueBinding(TopicExchange topicExchange) {
//        return BindingBuilder
//                .bind(subscriptionQueue())
//                .to(topicExchange)
//                .with(subscriptionRoutingKey);
//    }
//
//    @Bean
//    public MessageConverter jsonMessageConverter() {
//        return new Jackson2JsonMessageConverter();
//    }

}