package com.example.subscriptionapi.sub.controller;

import com.example.subscriptionapi.sub.dto.SubscriptionRequest;
import com.example.subscriptionapi.sub.dto.SubscriptionResponse;
import com.example.subscriptionapi.sub.repository.SubscriptionRepository;
import com.example.subscriptionapi.sub.service.SubscriptionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/subscription")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

//    SUBSCRIPTION_PURCHASED
    @PostMapping
    public SubscriptionResponse save(@RequestBody SubscriptionRequest request) {
        return subscriptionService.save(request);
    }

//    FIND ALL SUBSCRIPTIONS
    @GetMapping("all")
    public List<SubscriptionResponse> findAll() {
        return subscriptionService.findAll();
    }

//    FIND SUBSCRIPTIONS BY ID
    @GetMapping("{id}")
    public SubscriptionResponse findById(@PathVariable Integer id) {
        return subscriptionService.findByIdResponse(id);
    }

//    FIND SUBSCRIPTION BY CUSTOMER'S NAME
    @GetMapping("name/{name}")
    public List<SubscriptionResponse> findByName(@PathVariable String name) {
        return subscriptionService.findByName(name);
    }

//    CANCEL SUBSCRIPTION BY ID
    @PutMapping("cancel/{id}")
    public SubscriptionResponse cancel(@RequestBody SubscriptionRequest request, @PathVariable Integer id) {
        return subscriptionService.cancelled(request, id);
    }

//    RESTART SUBSCRIPTION BY ID
    @PutMapping("restart/{id}")
    public SubscriptionResponse restart(@RequestBody SubscriptionRequest request,
                                       @PathVariable Integer id) {
        return subscriptionService.restarted(request, id);
    }

}
