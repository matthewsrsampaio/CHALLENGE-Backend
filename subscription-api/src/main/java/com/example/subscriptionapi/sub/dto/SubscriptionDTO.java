package com.example.subscriptionapi.sub.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionDTO implements Serializable {

    private Integer id;
    private String status;
    private String name;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;

    public static SubscriptionDTO of(SubscriptionRequest request) {
        var  subscriptionDTO = new SubscriptionDTO();
        BeanUtils.copyProperties(request, subscriptionDTO);
        return subscriptionDTO;
    }

}
