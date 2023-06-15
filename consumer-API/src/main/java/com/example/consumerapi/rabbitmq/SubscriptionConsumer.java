package com.example.consumerapi.rabbitmq;

import com.example.consumerapi.dto.SubscriptionDTO;
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

    @RabbitListener(queues = "${app-config.rabbit.queue.consumer-update}")
    public void receiveSubscriptionMessage(SubscriptionDTO subDTO) throws JsonProcessingException {
        objectMapper.writeValueAsString(subDTO);
        log.info("Mensage received at consumer: {}", new ObjectMapper().writeValueAsString(subDTO), new ObjectMapper().registerModules());
    }

}
