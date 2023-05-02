package com.example.subscriptionapi.sub.dto;

import lombok.Data;

@Data // <- Vai gerar os getters and setters
public class SubscriptionRequest {

    private Integer id;
    private String status;
    private String name;

}
