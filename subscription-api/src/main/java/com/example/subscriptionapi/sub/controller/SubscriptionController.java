package com.example.subscriptionapi.sub.controller;

import com.example.subscriptionapi.sub.dto.SubscriptionRequest;
import com.example.subscriptionapi.sub.dto.SubscriptionResponse;
import com.example.subscriptionapi.sub.dto.SubscriptionResponse2;
import com.example.subscriptionapi.sub.service.SubscriptionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/subscription")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @PostMapping
    public SubscriptionResponse save(@RequestBody SubscriptionRequest request) {
        return subscriptionService.saveSubscription(request);
    }

    @GetMapping("all")
    public List<SubscriptionResponse> findAll() {
        return subscriptionService.findAll();
    }

    @GetMapping("{id}")
    public SubscriptionResponse findById(@PathVariable Integer id) {
        return subscriptionService.findByIdResponse(id);
    }

    @GetMapping("name/{name}")
    public List<SubscriptionResponse> findByName(@PathVariable String name) {
        return subscriptionService.findByName(name);
    }

    @PutMapping("cancel/{id}")
    public SubscriptionResponse2 cancel(@RequestBody SubscriptionRequest request, @PathVariable Integer id) {
        return subscriptionService.cancelSubscription(request, id);
    }

    @PutMapping("restart/{id}")
    public SubscriptionResponse2 restart(@RequestBody SubscriptionRequest request, @PathVariable Integer id) {
        return subscriptionService.restartSubscription(request, id);
    }

}
