package com.example.subscriptionapi.sub.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SubscriptionRequest {

    private Integer id;
    private String status;
    private String name;
    private LocalDateTime createdAt;

}
