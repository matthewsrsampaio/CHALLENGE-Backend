package com.example.subscriptionapi.sub.model;

import com.example.subscriptionapi.sub.dto.SubscriptionRequest;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.Module;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.Date;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SUBS")
public class SubscriptionModel {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "STATUS", nullable = false)
    private String status;

//    @Column(name = "CREATED_AT", nullable = false, updatable = false)
//    private LocalDateTime createdAt = LocalDateTime.now();

    //COPIES REQUEST TO MODEL
    public static SubscriptionModel of(SubscriptionRequest request) {
        var subscriptionModel = new SubscriptionModel();
        BeanUtils.copyProperties(request, subscriptionModel);
        return subscriptionModel;
    }
}
