package com.example.subscriptionapi.sub.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionDTO implements Serializable {

    private String id;
    private String status;
    private String name;

}
