package com.example.subscriptionapi.sub.rabbitmq;

import com.example.subscriptionapi.sub.dto.SubscriptionRequest;
import com.example.subscriptionapi.sub.dto.SubscriptionResponse;
import com.example.subscriptionapi.sub.model.SubscriptionModel;
import com.example.subscriptionapi.sub.service.SubscriptionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class SubscriptionConsumer {

    @Autowired
    private SubscriptionService subscriptionService;

    private final ObjectMapper objectMapper;

    @RabbitListener(queues = "${app-config.rabbit.queue.subscription-update}")
    public void receiveSubscriptionMessage(SubscriptionModel model) throws JsonProcessingException {
        log.info("Recebendo mensagem: {}", new ObjectMapper().writeValueAsString(model), new ObjectMapper().registerModules());
        objectMapper.writeValueAsString(model);
    }

}
