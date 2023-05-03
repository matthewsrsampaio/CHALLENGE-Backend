package com.example.subscriptionapi.sub.service;

import com.example.subscriptionapi.sub.config.exception.ValidationException;
import com.example.subscriptionapi.sub.dto.SubscriptionRequest;
import com.example.subscriptionapi.sub.dto.SubscriptionResponse;
import com.example.subscriptionapi.sub.model.SubscriptionModel;
import com.example.subscriptionapi.sub.repository.SubscriptionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.util.ObjectUtils.isEmpty;


@AllArgsConstructor
@Service
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

//    SUBSCRIPTION_PURCHASED
    public SubscriptionResponse save(SubscriptionRequest request) {
        request.setStatus("activated"); // <-quando houver um nova inscrição, o activated vai ser setado automaticamente
        validateSubscriptionNameInformed(request);
        var subscriptionModel = subscriptionRepository.save(SubscriptionModel.of(request));
        return SubscriptionResponse.of(subscriptionModel);
    }

//    SUBSCRIPTION_PURCHASED validation for empty cases
    private void validateSubscriptionNameInformed(SubscriptionRequest request) {
        if(isEmpty(request.getName())) {
            throw new ValidationException("The NEW subscription was not informed");
        }
    }

//    FIND ALL SUBSCRIPTIONS
    public List<SubscriptionResponse> findAll() {
        return subscriptionRepository
                .findAll()
                .stream()
                .map(SubscriptionResponse::of)
                .collect(Collectors.toList());
    }

//    FIND A SUBSCRIPTION INFO BY ITS ID
    public SubscriptionModel findById(Integer id) {
        return subscriptionRepository
                .findById(id)
                .orElseThrow(() -> new ValidationException("The ID informed doesn't exist."));
    }

//    ITS PART OF "FIND A SUBSCRIPTION INFO BY ITS ID", BUT RETURNS A RESPONSE.
    public SubscriptionResponse findByIdResponse(Integer id) {
        return SubscriptionResponse.of(findById(id));
    }

//    SEARCH SUBSCRIPTION INFO BY CUSTOMER'S NAME
    public List<SubscriptionResponse> findByName(String name) {
        return subscriptionRepository
                .findByNameIgnoreCaseContaining(name)
                .stream()
                .map(SubscriptionResponse::of)
                .collect(Collectors.toList());
    }

    public SubscriptionResponse cancelled(SubscriptionRequest request, Integer id) {
        SubscriptionModel subscription;
        subscription = SubscriptionModel.of(request);
        subscription.setId(id);
        subscription.setName(findById(id).getName());
        subscription.setStatus("deactivated");
        subscriptionRepository.save(subscription);
        return SubscriptionResponse.of(subscription);
    }

    public SubscriptionResponse restarted(SubscriptionRequest request, Integer id) {
        SubscriptionModel subscription;
        subscription = SubscriptionModel.of(request);
        subscription.setId(id);
        subscription.setName(findById(id).getName());
        subscription.setStatus("activated");
        subscriptionRepository.save(subscription);
        return SubscriptionResponse.of(subscription);
    }
}
