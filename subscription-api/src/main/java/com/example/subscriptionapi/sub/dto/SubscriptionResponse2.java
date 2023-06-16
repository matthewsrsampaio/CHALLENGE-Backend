package com.example.subscriptionapi.sub.dto;

import com.example.subscriptionapi.sub.model.SubscriptionModel;
import com.example.subscriptionapi.sub.model.SubscriptionModel2;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionResponse2 {

    private Integer id;
    private String name;
    private String status;
    @Column(name = "CREATED_AT")
//    @JsonFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt = LocalDateTime.now();
    @Column(name = "UPDATED_AT")
//    @JsonFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt = LocalDateTime.now();

    public static SubscriptionResponse2 of(SubscriptionModel2 model) {
        var response = new SubscriptionResponse2();
        BeanUtils.copyProperties(model, response);
        return response;
    }

}
