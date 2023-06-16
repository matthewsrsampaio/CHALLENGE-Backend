package com.example.subscriptionapi.sub.dto;

import com.example.subscriptionapi.sub.model.SubscriptionModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionDTO implements Serializable {

    private Integer id;
    private String status;
    private String name;

    public static SubscriptionDTO of(SubscriptionRequest request) {
        var  subscriptionDTO = new SubscriptionDTO();
        BeanUtils.copyProperties(request, subscriptionDTO);
        return subscriptionDTO;
    }

//    @Column(name = "CREATED_AT")
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
//    private LocalDate createdAt = LocalDate.now();

}
