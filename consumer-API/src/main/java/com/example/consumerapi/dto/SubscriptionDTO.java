package com.example.consumerapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionDTO implements Serializable {

    private Integer id;
    private String status;
    private String name;

}
