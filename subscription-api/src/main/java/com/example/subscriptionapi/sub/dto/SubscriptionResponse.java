package com.example.subscriptionapi.sub.dto;

import com.example.subscriptionapi.sub.model.SubscriptionModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Data // <- GETTER AND SETTERS....
@NoArgsConstructor // EMPTY CONSTRUCTOR
@AllArgsConstructor // FULL CONSTRUCTOR
public class SubscriptionResponse {

    private Integer id;
    private String name;
    private String status;
    @JsonProperty("created_at")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime createdAt;

    //COPIES ALL MODEL TO RESPONSE
    public static SubscriptionResponse of(SubscriptionModel model) {
        var response = new SubscriptionResponse();
        BeanUtils.copyProperties(model, response); //HERE IS WHERE THE MAGIC HAPPENS
        return response;
    }

}
