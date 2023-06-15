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


@Data //CREATES GETTER AND SETTERS, HASHMAPS, ETC..
@Entity //INFORMS JAKARTA THAT THIS CLASS IS AN ENTITY
@Builder
@NoArgsConstructor //CREATE EMPTY CONSTRUCTORS
@AllArgsConstructor //CREATE CONSTRUCTORS
@Table(name = "SUBS")
public class SubscriptionModel {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)  //CREATES A SEQUENCE TO HIBERNATE
    private Integer id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "STATUS", nullable = false)
    private String status;

//    @Column(name = "CREATED_AT", nullable = false, updatable = false)
//    private LocalDateTime createdAt = LocalDateTime.now(); // <-EVERY TIME A INSTANCE IS CREATED A NEW DATE IS SET

    //COPIES REQUEST TO MODEL
    public static SubscriptionModel of(SubscriptionRequest request) {
        var subscriptionModel = new SubscriptionModel();
        BeanUtils.copyProperties(request, subscriptionModel); //HERE IS WHERE THE MAGIC HAPPENS
        return subscriptionModel;
    }
}
