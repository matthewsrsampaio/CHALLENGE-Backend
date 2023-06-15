package com.example.subscriptionapi.sub.rabbitmq;

import com.example.subscriptionapi.sub.dto.SubscriptionDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class SubscriptionConsumer {

    private final ObjectMapper objectMapper;

    @RabbitListener(queues = "${app-config.rabbit.queue.subscription-update}")
    public void receiveSubscriptionMessage(SubscriptionDTO subDTO) throws JsonProcessingException {
        objectMapper.writeValueAsString(subDTO);
        log.info("Message received: {}", new ObjectMapper().writeValueAsString(subDTO), new ObjectMapper().registerModules());
    }

}
