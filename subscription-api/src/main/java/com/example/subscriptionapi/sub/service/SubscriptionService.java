package com.example.subscriptionapi.sub.service;


import com.example.subscriptionapi.sub.config.exception.ValidationException;
import com.example.subscriptionapi.sub.dto.SubscriptionRequest;
import com.example.subscriptionapi.sub.dto.SubscriptionResponse;
import com.example.subscriptionapi.sub.dto.SubscriptionResponse2;
import com.example.subscriptionapi.sub.model.SubscriptionModel;
import com.example.subscriptionapi.sub.model.SubscriptionModel2;
import com.example.subscriptionapi.sub.rabbitmq.SubscriptionProducer;
import com.example.subscriptionapi.sub.repository.SubscriptionRepository;
import com.example.subscriptionapi.sub.repository.SubscriptionRepository2;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.util.ObjectUtils.isEmpty;


@AllArgsConstructor
@Service
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    @Autowired
    private final SubscriptionProducer subscriptionProducer;
    private final SubscriptionRepository2 subscriptionRepository2;

    public SubscriptionResponse saveSubscription(SubscriptionRequest request) {
        validateSubscriptionNameInformed(request);
        SubscriptionModel subscription;
        subscription = SubscriptionModel.of(request);
        subscriptionProducer.produceMessage(subscription);
        var subscriptionModel = subscriptionRepository.save(subscription);
        return SubscriptionResponse.of(subscriptionModel);
    }

    private void validateSubscriptionNameInformed(SubscriptionRequest request) {
        if(isEmpty(request.getName())) {
            throw new ValidationException("The NEW subscription was not informed");
        }
    }

    public List<SubscriptionResponse> findAll() {
        return subscriptionRepository
                .findAll()
                .stream()
                .map(SubscriptionResponse::of)
                .collect(Collectors.toList());
    }

    public SubscriptionModel findById(Integer id) {
        return subscriptionRepository
                .findById(id)
                .orElseThrow(() -> new ValidationException("The ID informed doesn't exist."));
    }

    public SubscriptionResponse findByIdResponse(Integer id) {
        return SubscriptionResponse.of(findById(id));
    }

    public List<SubscriptionResponse> findByName(String name) {
        return subscriptionRepository
                .findByNameIgnoreCaseContaining(name)
                .stream()
                .map(SubscriptionResponse::of)
                .collect(Collectors.toList());
    }

    public SubscriptionResponse2 cancelSubscription(SubscriptionRequest request, Integer id) {
        SubscriptionModel2 subscription;
        subscription = SubscriptionModel2.of(request);
        subscription.setId(id);
        subscription.setName(findById(id).getName());
        subscription.setStatus("deactivated");
        subscriptionRepository2.save(subscription);
        subscriptionProducer.produceMessageSubscription2(subscription);
        return SubscriptionResponse2.of(subscription);
    }

    public SubscriptionResponse2 restartSubscription(SubscriptionRequest request, Integer id) {
        SubscriptionModel2 subscription;
        subscription = SubscriptionModel2.of(request);
        subscription.setId(id);
        subscription.setName(findById(id).getName());
        subscription.setStatus("activated");
        subscriptionRepository2.save(subscription);
        subscriptionProducer.produceMessageSubscription2(subscription);
        return SubscriptionResponse2.of(subscription);
    }

}
