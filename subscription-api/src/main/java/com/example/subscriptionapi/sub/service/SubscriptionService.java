package com.example.subscriptionapi.sub.service;

import com.example.subscriptionapi.sub.dto.SubscriptionRequest;
import com.example.subscriptionapi.sub.dto.SubscriptionResponse;
import com.example.subscriptionapi.sub.model.SubscriptionModel;
import com.example.subscriptionapi.sub.repository.SubscriptionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final ObjectMapper objectMapper;

    public SubscriptionResponse save(SubscriptionRequest request) {
        var subscriptionModel = subscriptionRepository.save(SubscriptionModel.of(request));
        return SubscriptionResponse.of(subscriptionModel);
    }
}
