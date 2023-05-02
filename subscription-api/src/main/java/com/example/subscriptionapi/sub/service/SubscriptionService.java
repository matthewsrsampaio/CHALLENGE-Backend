package com.example.subscriptionapi.sub.service;

import com.example.subscriptionapi.sub.config.exception.ValidationException;
import com.example.subscriptionapi.sub.dto.SubscriptionRequest;
import com.example.subscriptionapi.sub.dto.SubscriptionResponse;
import com.example.subscriptionapi.sub.model.SubscriptionModel;
import com.example.subscriptionapi.sub.repository.SubscriptionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static org.springframework.util.ObjectUtils.isEmpty;


@AllArgsConstructor
@Service
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
//    private final ObjectMapper objectMapper;

    //SUBSCRIPTION_PURCHASED
    public SubscriptionResponse save(SubscriptionRequest request) {
        request.setStatus("activated"); // <-quando houver um nova inscrição, o activated vai ser setado automaticamente
        validateSubscriptionNameInformed(request);
        var subscriptionModel = subscriptionRepository.save(SubscriptionModel.of(request));
        return SubscriptionResponse.of(subscriptionModel);
    }
    //SUBSCRIPTION_PURCHASED validation for empty cases
    private void validateSubscriptionNameInformed(SubscriptionRequest request) {
        if(isEmpty(request.getName())) {
            throw new ValidationException("The NEW subscription was not informed");
        }
    }

}
