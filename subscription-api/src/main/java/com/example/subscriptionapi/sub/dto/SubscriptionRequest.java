package com.example.subscriptionapi.sub.dto;

import lombok.Data;

@Data
public class SubscriptionRequest {

    private Integer id;
    private String status;
    private String name;

}
