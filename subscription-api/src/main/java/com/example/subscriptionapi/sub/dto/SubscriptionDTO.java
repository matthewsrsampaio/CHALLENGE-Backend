package com.example.subscriptionapi.sub.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionDTO implements Serializable {

    private Integer id;
    private String status;
    private String name;

}
