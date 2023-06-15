package com.example.consumerapi.rabbitConfig;

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

    @Value("${app-config.rabbit.exchange.subscription-api}")
    private String subscriptionTopicExchange;

    @Value("${app-config.rabbit.routingKey.consumer-update}")
    private String consumerRoutingKey;

    @Value("${app-config.rabbit.queue.consumer-update}")
    private String consumerQueue;

    @Bean
    public TopicExchange subscriptionTopicExchange() {
        return new TopicExchange(subscriptionTopicExchange);
    }

    @Bean
    public Queue consumerQueue() {
        return new Queue(consumerQueue, true);
    }

    @Bean
    public Binding consumerTopicQueueBinding(TopicExchange topicExchange) {
        return BindingBuilder
                .bind(consumerQueue())
                .to(topicExchange)
                .with(consumerRoutingKey);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
